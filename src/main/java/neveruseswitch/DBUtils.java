package neveruseswitch;

import org.fluttercode.datafactory.impl.DataFactory;

/**
 * Created by Evegeny on 24/07/2016.
 */
public class DBUtils {
    private static DataFactory dataFactory = new DataFactory();
    public static MailInfo getMailInfo() {
        return new MailInfo(dataFactory.getName(), dataFactory.getNumberBetween(1, 3));
    }
}
