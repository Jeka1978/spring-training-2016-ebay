package mySpring;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class BenchmarkProxyCleaner implements Cleaner {
    @InjectByType
    private PowerCleaner powerCleaner;
    @Override
    public void clean() {
        System.out.println("BENCHMAKk");
        powerCleaner.clean();
        System.out.println("BENCHMAKk");
    }
}
