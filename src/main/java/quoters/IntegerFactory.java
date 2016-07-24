package quoters;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

/**
 * Created by Evegeny on 24/07/2016.
 */
@AllArgsConstructor
public class IntegerFactory implements FactoryBean {

    private int max;

    @Override
    public Object getObject() throws Exception {
        Random random = new Random();
        return random.nextInt(max);
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
