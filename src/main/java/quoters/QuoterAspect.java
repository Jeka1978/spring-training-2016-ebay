package quoters;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component
@Aspect
public class QuoterAspect {

    @Before("execution(* quoters..*.say*(..))")
    public void beforeSayMethods() {
        System.out.println("this is quote: ");
    }
}
