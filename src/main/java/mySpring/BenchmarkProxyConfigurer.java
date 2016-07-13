package mySpring;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class BenchmarkProxyConfigurer implements ProxyConfigurer {
    @Override
    public Object wrapWithProxy(Object o, Class type) {
        boolean proxyNeeded = false;
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                proxyNeeded = true;
            }
        }

        if (type.isAnnotationPresent(Benchmark.class) || proxyNeeded) {

            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return BenchmarkProxyConfigurer.invoke(method, args, o,type);
                    }
                });
            }

            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return BenchmarkProxyConfigurer.invoke(method, args, o,type);
                }
            });
        }
        return o;
    }

    private static Object invoke(Method method, Object[] args, Object o,Class type) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Benchmark.class)||type.isAnnotationPresent(Benchmark.class)) {
            System.out.println("**************BENCHMARK STARTED*************");
            long start = System.nanoTime();
            Object retVal = method.invoke(o, args);
            long end = System.nanoTime();
            System.out.println("method " + method.getName() + " was working for " + (end - start) + " nanos");
            System.out.println("**************BENCHMARK FINISHED*************");
            return retVal;
        }else {
            return method.invoke(o, args);
        }
    }
}




