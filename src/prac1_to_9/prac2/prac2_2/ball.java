package prac1_to_9.prac2.prac2_2;

public class ball {
    private double x = 0.0;
    private double y = 0.0;

    public ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public ball() {
        this(0.0,0.0);
    }

    public double getX() {return x;}
    public double getY() {return y;}

    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double xDisp, double yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    @Override
    public String toString() {
        return "x = " + x + "\n" + "y = " + y + "\n";
    }
}
