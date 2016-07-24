package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component("3")
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "Happy birthday " + mailInfo.getClientName();
    }
}
