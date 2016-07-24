package screenSaver;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component
public class Starter {
    @Autowired
    private ApplicationContext context;

    @PostConstruct
    @SneakyThrows
    public void init() {
        while (true) {
            context.getBean(ColorFrame.class).changeLocation();
            Thread.sleep(50);
        }
    }
}
