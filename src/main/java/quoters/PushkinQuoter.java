package quoters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component
@Book
public class PushkinQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("Я помню чудное мгновенье");
    }
}
