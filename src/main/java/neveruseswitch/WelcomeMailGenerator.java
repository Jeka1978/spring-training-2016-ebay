package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "<html> Welcome " + mailInfo.getClientName() + " </html>";
    }

    @Override
    public int mailCode() {
        return 1;
    }
}
