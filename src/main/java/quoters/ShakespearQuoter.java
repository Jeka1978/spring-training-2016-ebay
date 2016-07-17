package quoters;

import mySpring.InjectRandomInt;

/**
 * Created by Evegeny on 17/07/2016.
 */
public class ShakespearQuoter implements Quoter {

    @InjectRandomInt(min = 3, max = 5)
    private int repeat;

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
