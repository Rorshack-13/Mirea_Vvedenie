package prac10_to_19.prac12.prac12_1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MShape {
    protected Color color;
    protected int x;
    protected int y;

    public MShape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}