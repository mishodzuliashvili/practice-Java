package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {
    private MListener mls;
    private OptionalWindow optionalWindow;
    private Color toolColor;
    private Graphics2D g2;
    private BufferedImage image;

    private final int SCALE = 4;
    //tools
    private int toolX,toolY,toolR,toolG,toolB,toolW,toolH;
    private List<Tool> toolList;

    public PaintPanel(OptionalWindow optionalWindow){
        this.optionalWindow = optionalWindow;
        mls = new MListener();
        addMouseListener(mls);
        addMouseMotionListener(mls);
        image = new BufferedImage(MainFrame.WIDTH / SCALE,MainFrame.HEIGHT / SCALE,
                BufferedImage.TYPE_INT_RGB);


        g2 = (Graphics2D) image.getGraphics();

        toolList = new ArrayList<Tool>();
        draw();
        repaint();
    }

    public void paintComponent(Graphics g){
        g.drawImage(image,0,0,MainFrame.WIDTH, MainFrame.HEIGHT  ,null);

    }
    public void addStroke(MouseEvent s){
        toolX = s.getX() / SCALE;
        toolY = s.getY() / SCALE;
        toolH = 8;
        toolW = 8;
        toolR = optionalWindow.getThirdValue();
        toolG = optionalWindow.getSecondValue();
        toolB = optionalWindow.getFirstValue();
        toolColor = new Color(toolR,toolG,toolB);
        toolList.add(new Circle(toolX,toolY,toolW,toolH,toolColor));
        draw();
        repaint();
    }
    public void draw(){
        drawBackground();
        drawStrokes();
    }

    public void drawStrokes() {
        for (Tool t: toolList) {
            t.setAttributes(g2);
            t.draw(g2);
        }
    }

    public void drawBackground() {
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,image.getWidth(),image.getHeight());

    }

    public class MListener implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            addStroke(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
