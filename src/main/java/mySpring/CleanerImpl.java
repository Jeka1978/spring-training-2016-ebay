package mySpring;

/**
 * Created by Evegeny on 13/07/2016.
 */
@Transcational
@Benchmark
public class CleanerImpl implements Cleaner {
    @Override
    public void clean() {
        System.out.println("VVVVVVVVvvvvvvvvvvvv");
    }
}
