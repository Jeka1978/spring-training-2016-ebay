package mySpring;

import org.springframework.core.annotation.Order;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class InjectRandomIntAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object object) throws IllegalAccessException {
        Class<?> type = object.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(object,value);
            }
        }
    }
}
