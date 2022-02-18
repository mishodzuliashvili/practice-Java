package com.company;

import java.awt.*;

public class Circle extends Tool{

    public Circle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics2D g) {
        g.fillOval(x,y,width,height);
    }
}
