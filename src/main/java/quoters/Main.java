package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Evegeny on 17/07/2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println(context.getBean("integer"));
        System.out.println(context.getBean("integer2"));
//        TalkingRobot robot = context.getBean(TalkingRobot.class);

       /* while (true) {
            robot.talk();
            Thread.sleep(500);
        }*/
    }
}
