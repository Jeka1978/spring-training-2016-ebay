package labAop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Evegeny on 27/07/2016.
 */
@Component
@Aspect
public class ExceptionHandlerAspect {
    @Value("${dbaMails}")
    private String[] mails;

    private Map<DBRuntimeException, Void> map = new WeakHashMap<>();


    @AfterThrowing(value = "execution(* labAop..*.*(..))",throwing = "ex")
    public void handleDBException(DBRuntimeException ex) {
        if (!map.containsKey(ex)) {
            map.put(ex, null);
            for (String mail : mails) {
                System.out.println("sending mail to "+mail+" ex message: "+ex.getMessage());
            }
        }
    }


}
