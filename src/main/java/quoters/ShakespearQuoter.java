package quoters;

import mySpring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 17/07/2016.
 */
@Component
@Book
public class ShakespearQuoter implements Quoter {

    @InjectRandomInt(min = 3, max = 5)
    private int repeat;

    @Value("${shake}")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
