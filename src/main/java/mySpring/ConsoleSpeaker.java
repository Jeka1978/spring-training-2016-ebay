package mySpring;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
