package mySpring;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 13/07/2016.
 */
@Benchmark
public class IRobotImpl implements IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
//        System.out.println(speaker.getClass().getName());
    }

    @Override
    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
