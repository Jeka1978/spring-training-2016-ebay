package labAop;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 27/07/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("labAop");
        context.getBean(OneService.class).doX();
       /* try {
            context.getBean(AnotherService.class).doSomething();
        } catch (Exception e) {
            System.out.println("handling exception");
        }
        try {
            context.getBean(AnotherService.class).doSomething();
        } catch (Exception e) {
            System.out.println("handling exception");
        }*/
    }
}
