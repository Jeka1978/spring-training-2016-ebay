package neveruseswitch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 24/07/2016.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config.class);
    }
}
