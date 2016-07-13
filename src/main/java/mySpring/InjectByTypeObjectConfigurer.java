package mySpring;

import java.lang.reflect.Field;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class InjectByTypeObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object t) throws Exception {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Class<?> type = field.getType();
                Object value = ObjectFactory.getInstance().createObject(type);
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }
}
