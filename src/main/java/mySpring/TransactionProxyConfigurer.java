package mySpring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class TransactionProxyConfigurer implements ProxyConfigurer {
    @Override
    public Object wrapWithProxy(Object o, Class type) {

        if (type.isAnnotationPresent(Transcational.class)) {


            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("**************TRANSACTION STARTED*************");
                    Object retVal = method.invoke(o, args);
                    System.out.println("**************Transaction Commited*************");
                    return retVal;
                }
            });
        }
        return o;
    }
}
