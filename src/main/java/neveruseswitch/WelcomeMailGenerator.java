package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "<html> Welcome " + mailInfo.getClientName() + " </html>";
    }
}
