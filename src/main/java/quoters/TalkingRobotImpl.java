package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 17/07/2016.
 */
@Component
public class TalkingRobotImpl implements TalkingRobot {

    @Autowired(required = false)
    private List<Quoter> quoters = Arrays.asList(new Quoter() {
        @Override
        public void sayQuote() {
            System.out.println("this is default");
        }
    });

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
