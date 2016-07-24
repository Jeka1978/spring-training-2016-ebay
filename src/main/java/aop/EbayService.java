package aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Service
@EnableAspectJAutoProxy
public class EbayService {
    public void doWork() {
        System.out.println("Working...");
    }
}
