package mySpring;

import javax.swing.*;

/**
 * Created by Evegeny on 13/07/2016.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
