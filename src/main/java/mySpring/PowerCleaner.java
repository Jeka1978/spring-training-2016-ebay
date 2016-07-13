package mySpring;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 13/07/2016.
 */
@Benchmark
public class PowerCleaner implements Cleaner {
    @InjectRandomInt(min=3,max =7)
    private int repeat;

    @PostConstruct
    public void  init() {
        System.out.println("repeat = " + repeat);
    }

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("FFFFFFFFFffshhhhhhhhhhhhhh");
        }

    }
}
