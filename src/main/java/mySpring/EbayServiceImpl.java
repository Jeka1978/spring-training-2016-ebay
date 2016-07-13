package mySpring;

/**
 * Created by Evegeny on 13/07/2016.
 */
@Benchmark
public class EbayServiceImpl implements EbayService {
    @Override
    public void doWork() {
        System.out.println("Working...");
    }

    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Leff is good");
    }
}
