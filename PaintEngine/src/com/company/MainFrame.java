package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static int WIDTH = 500;
    public static int HEIGHT = 700;
    private static PaintPanel panel;
    private static JFrame window;
    private static OptionalWindow optionalWindow;
    public MainFrame() {
        window = new JFrame("Engine");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH,HEIGHT);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        optionalWindow = new OptionalWindow();
        panel = new PaintPanel(optionalWindow);
        window.add(panel);
        window.setVisible(true);

    }
    public static Point getLocationOfW(){
        return window.getLocation();
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        MainFrame test = new MainFrame();
    }
}


