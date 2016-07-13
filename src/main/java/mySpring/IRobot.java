package mySpring;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

   /* public IRobot() {
        System.out.println(speaker.getClass().getName());
    }*/

    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
