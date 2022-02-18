package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class OptionalWindow {
    private CListener cListener;
    private JFrame frame;
    private JPanel panel;
    private static final int WIDTH = 220;
    private JSlider fisrtS,secondS,thirdS;
    public OptionalWindow(){
        initialize();
        setAttributes();
        addSTPanel();
        createFrame();
    }

    public void initialize(){
        frame = new JFrame("Options");
        panel = new JPanel();

        fisrtS = new JSlider(0,255);
        secondS = new JSlider(0,255);
        thirdS = new JSlider(0,255);

        cListener = new CListener();

    }

    public void setAttributes(){
        thirdS.setBorder(BorderFactory.createTitledBorder("Red"));
        thirdS.setMajorTickSpacing(100);
        thirdS.setValue(100);
        thirdS.setPaintTicks(true);
        thirdS.setPaintLabels(true);
        thirdS.addChangeListener(cListener);

        secondS.setBorder(BorderFactory.createTitledBorder("Green"));
        secondS.setMajorTickSpacing(100);
        secondS.setValue(100);
        secondS.setPaintTicks(true);
        secondS.setPaintLabels(true);
        secondS.addChangeListener(cListener);


        fisrtS.setBorder(BorderFactory.createTitledBorder("Blue"));
        fisrtS.setMajorTickSpacing(100);
        fisrtS.setValue(100);
        fisrtS.setPaintTicks(true);
        fisrtS.setPaintLabels(true);
        fisrtS.addChangeListener(cListener);

    }
    public void addSTPanel(){
        panel.add(fisrtS);
        panel.add(secondS);
        panel.add(thirdS);
    }
    public void createFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH,MainFrame.HEIGHT);

        Point loc = MainFrame.getLocationOfW();
        loc.setLocation(loc.getX() - WIDTH, loc.getY());

        frame.setLocation(loc);

        frame.add(panel);
        frame.setVisible(true);
    }
    public int getFirstValue(){
        return fisrtS.getValue();
    }
    public int getSecondValue(){
        return secondS.getValue();
    }
    public int getThirdValue(){
        return thirdS.getValue();
    }
    private class CListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            int first = fisrtS.getValue();
            int second = secondS.getValue();
            int third = thirdS.getValue();

            Color c = new Color(third,second,first);
            panel.setBackground(c);

        }
    }
}
