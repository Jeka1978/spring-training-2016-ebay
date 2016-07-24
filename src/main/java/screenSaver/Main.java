package screenSaver;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 24/07/2016.
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("screenSaver");
        while (true) {
            context.getBean(ColorFrame.class).changeLocation();
            Thread.sleep(50);
        }
    }
}
