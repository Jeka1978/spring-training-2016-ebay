package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Service
public class MailSender {

    @Autowired
    private Map<String,MailGenerator> map;

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail(){
        MailInfo mailInfo = DBUtils.getMailInfo();
        MailGenerator mailGenerator = map.get(Integer.toString(mailInfo.getMailCode()));
        if (mailGenerator == null) {
            throw new RuntimeException("mailcode " + mailInfo.getMailCode() + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html);

    }

    private void send(String html) {
        System.out.println("Sending "+html);
    }
}







