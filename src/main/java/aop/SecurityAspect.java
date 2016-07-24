package aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component
@Aspect
public class SecurityAspect {

    @Pointcut("execution(* aop..*Service.*(..))")
    public void servicesMethods() {}

    @Before("@annotation(neveruseswitch.Log)")
    public void logMethods() {
    }

    @Around("servicesMethods()")
    public Object doSecured(ProceedingJoinPoint pjp) throws Throwable {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            return pjp.proceed();
        }else {
            throw new RuntimeException("not allowed here, try again later...");
        }
    }

}









