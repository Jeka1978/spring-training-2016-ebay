package mySpring;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        EbayService ebayService = ObjectFactory.getInstance().createObject(EbayService.class);
        ebayService.doWork();
        ebayService.drinkBeer();
    }
}
