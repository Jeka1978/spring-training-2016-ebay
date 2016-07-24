package neveruseswitch;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Evegeny on 24/07/2016.
 */
@Data
@AllArgsConstructor
public class MailInfo {
    private String clientName;
    private int mailCode;
}
