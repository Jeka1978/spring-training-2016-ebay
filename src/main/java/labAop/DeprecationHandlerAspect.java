package labAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Component
@Aspect
public class DeprecationHandlerAspect {

    @After("@annotation(Deprecated))")
    public void handleDeprecated(JoinPoint jp){
        System.out.println("You are using deprecated method "+jp.getSignature().getName());
    }
}
