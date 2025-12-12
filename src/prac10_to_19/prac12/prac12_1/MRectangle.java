package prac10_to_19.prac12.prac12_1;

import java.awt.Color;
import java.awt.Graphics;

public class MRectangle extends MShape {
    private int a;
    private int b;

    public MRectangle(Color color, int x, int y, int a, int b) {
        super(color, x, y);
        this.a = a;
        this.b =b;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, a, b);
    }
}
