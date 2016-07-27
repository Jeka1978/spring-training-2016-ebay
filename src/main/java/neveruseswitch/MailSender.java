package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Service
public class MailSender {


    private Map<Integer,MailGenerator> map = new HashMap<>();

    @Autowired
    private void initMap(List<MailGenerator> mailGenerators) {
        for (MailGenerator mailGenerator : mailGenerators) {
            int mailCode = mailGenerator.mailCode();
            if (map.containsKey(mailCode)) {
                throw new RuntimeException("mailcode " + mailCode + " already in use");
            }
            map.put(mailCode, mailGenerator);
        }
    }

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail(){
        MailInfo mailInfo = DBUtils.getMailInfo();
        MailGenerator mailGenerator = map.get(mailInfo.getMailCode());
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







