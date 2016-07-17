package quoters;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Evegeny on 17/07/2016.
 */
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    public TalkingRobotImpl(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
