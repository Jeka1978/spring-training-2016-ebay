package mySpring;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();

    private Config config = new JavaConfig();
    private Reflections reflections = new Reflections("mySpring");

    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = reflections.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                try {
                    objectConfigurers.add(aClass.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public <T> T createObject(Class<T> type) throws Exception {

        type = resolveImplClass(type);
        T t = type.newInstance();
        configure(t);


        return t;
    }

    private <T> void configure(T t) throws IllegalAccessException {
        for (ObjectConfigurer objectConfigurer : objectConfigurers) {
            objectConfigurer.configure(t);
        }
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












