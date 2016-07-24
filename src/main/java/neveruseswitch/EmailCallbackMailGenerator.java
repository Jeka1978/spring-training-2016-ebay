package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component("2")
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "<html> don't call us we call you </html>";
    }
}
