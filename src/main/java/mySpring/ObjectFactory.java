package mySpring;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private Config config = new JavaConfig();
    private Reflections reflections = new Reflections("mySpring");

    private ObjectFactory() {
    }

    public <T> T createObject(Class<T> type) throws Exception {

        type = resolveImplClass(type);
        T t = type.newInstance();



        return t;
    }














    private <T> Class<T> resolveImplClass(Class<T> type) {
        if (type.isInterface()) {
            Class implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException("0 or more than one impl class found for interface " + type + " please bind needed impl in your config");
                }
                type = (Class<T>) classes.iterator().next();
            }else {
                type = implClass;
            }
        }
        return type;
    }
}












