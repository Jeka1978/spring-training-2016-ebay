package quoters;

import mySpring.Benchmark;
import mySpring.Transcational;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;

import javax.annotation.PostConstruct;
import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 17/07/2016.
 */
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    private BenchmarkController benchmarkController = new BenchmarkController();

    @PostConstruct
    public void init() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(benchmarkController, new ObjectName("ebayMBeans", "name", "becnhmarKKK"));
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Benchmark.class)) {
            map.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Class beanClass = map.get(beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(),beanClass.getInterfaces(),(o, method, args) -> {
                if (benchmarkController.isEnabled()) {
                    System.out.println("************BENCHMARK***************");
                    Object retVal = method.invoke(bean, args);
                    System.out.println("************end BENCHMARK***************");
                    return retVal;
                }else {
                    return method.invoke(bean, args);
                }
            });
        }
        return bean;
    }
}
