package quoters;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by Evegeny on 17/07/2016.
 */
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @PreDestroy
    public void killAll(){
        System.out.println("You are terminated...");
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
