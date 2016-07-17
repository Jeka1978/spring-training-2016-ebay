package mySpring;

import org.springframework.aop.support.AopUtils;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
   /*     EbayServiceImpl ebayService = ObjectFactory.getInstance().createObject(EbayServiceImpl.class);
        ebayService.doWork();
        ebayService.drinkBeer();
        System.out.println(ebayService.getClass());*/
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
        Class<?> targetClass = AopUtils.getTargetClass(iRobot);
        System.out.println("############################################");
        System.out.println(iRobot.getClass());
        System.out.println(targetClass.getName());
    }
}
