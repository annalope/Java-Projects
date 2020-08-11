package com.codebind;

import java.awt.*;

public class Arcs {
    private int x;
    private int y;
    private int radius;
    private int startAngle;
    private int endAngle;
    private Color color;

    public Arcs(int x, int y, int radius, int startAngle, int endAngle, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.color = color;
    }

    public int getStartAngle() {
        return startAngle;
    }

    public int getEndAngle() {
        return endAngle;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
