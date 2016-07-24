package quoters;

import mySpring.Transcational;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 17/07/2016.
 */
@Component
public class TransactionalAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Transcational.class)) {
            map.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Class beanClass = map.get(beanName);
            return Proxy.newProxyInstance(beanClass.getClassLoader(),beanClass.getInterfaces(),(o, method, args) -> {
                System.out.println("Transaction opened");
                Object retVal = method.invoke(bean, args);
                System.out.println("Transaction commited");
                return retVal;
            });
        }
        return bean;
    }
}






