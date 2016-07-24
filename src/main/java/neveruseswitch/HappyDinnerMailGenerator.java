package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Component
public class HappyDinnerMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "lets go to eat!";
    }

    @Override
    public int mailCode() {
        return 4;
    }
}
