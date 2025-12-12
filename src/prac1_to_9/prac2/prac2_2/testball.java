package prac1_to_9.prac2.prac2_2;

public class testball {
    public static void main(String[] args) {
        ball ball1 = new ball();
        ball ball2 = new ball(10.0,20.0);

        System.out.println("Начальные координаты ball1" + "(" + ball1.getX() + "," + ball1.getY() + ")");
        System.out.println("Начальные координаты ball2" + "(" + ball2.getX() + "," + ball2.getY() + ")");
        System.out.print("\n");

        ball1.setX(3.1);
        ball1.setY(4.1);
        System.out.println("ball1 после setX и setY: (" + ball1.getX() + "," + ball1.getY() + ")");

        ball2.setXY(0.1,1.5);
        System.out.println("ball2 после setXY: (" + ball2.getX() + "," + ball2.getY() + ")" + "\n");

        ball2.move(5,5);
        System.out.println("ball2 после move(5,5): (" + ball2.getX() + "," + ball2.getY() + ")" + "\n");

        System.out.println("ball1: " + "\n" + ball1.toString());
        System.out.println("ball2: " + "\n" + ball2.toString());
    }
}
