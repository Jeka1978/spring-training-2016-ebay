package neveruseswitch;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Service
public class MailSender {

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail(){
        MailInfo mailInfo = DBUtils.getMailInfo();
        switch (mailInfo.getMailCode()) {
            case 1:
                //80 lines of code
                System.out.println("Welcome client: " + mailInfo.getClientName());
                break;
            default:
                //60 lines of code
                System.out.println("don't call us we call you");
                break;
        }
    }
}
