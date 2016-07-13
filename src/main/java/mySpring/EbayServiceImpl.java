package mySpring;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class EbayServiceImpl implements EbayService {
    @Override
    public void doWork() {
        System.out.println("Working...");
    }

    @Override
    public void drinkBeer() {
        System.out.println("Leff is good");
    }
}
