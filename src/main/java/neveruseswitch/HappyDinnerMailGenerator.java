package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component("4")
public class HappyDinnerMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "lets go to eat!";
    }
}
