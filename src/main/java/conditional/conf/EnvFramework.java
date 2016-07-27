package conditional.conf;

import java.util.Random;

/**
 * Created by Evegeny on 27/07/2016.
 */
public class EnvFramework {
    public static String getEnv() {
        Random random = new Random();
       /* if (random.nextInt(2) == 1) {
            return "Prod";
        }
        else {
            return "test";
        }*/
        return "prod";
    }
}
