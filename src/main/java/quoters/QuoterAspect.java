package quoters;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component
@Aspect
public class QuoterAspect {

    @Before("@annotation(neveruseswitch.Log)")
    public void beforeSay(JoinPoint jp) {
        System.out.println("This is quote "+jp.getTarget().getClass().getSimpleName());
    }



}
