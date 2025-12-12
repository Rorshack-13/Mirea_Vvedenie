package prac1_to_9.prac2.prac2_6;

public class circle {
    private double r;

    public circle(double r) {
        this.r = r;
    }

    public void setR(double r) {this.r = r;}
    public double getR() {return r;}

    public double Scircle() {
        return Math.PI*(r*r);
    }

    public double Lcircle() {
        return Math.PI*2*r;
    }

    public boolean srav(circle other) {
        if (this.r == other.r) {
            System.out.println("Окружности равны");
            return true;
        }
        else {
            System.out.println("Окружности не равны");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Радиус = " + r + "\n" + "Длина = " + Lcircle() + "\n" + "Площадь = " + Scircle() + "\n";
    }
}

