package screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 24/07/2016.
 */
public abstract class ColorFrame  extends JFrame{
    @Autowired
    private Color color;

    @PostConstruct
    private void init() {
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void changeLocation() {
        Random random = new Random();
        setLocation(random.nextInt(1200),random.nextInt(900));
        color = getColorBean();
        getContentPane().setBackground(color);
        repaint();
    }

    protected abstract Color getColorBean();
}


















