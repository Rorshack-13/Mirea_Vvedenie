package prac1_to_9.prac2.prac2_6;

public class circletest {
    public static void main(String[] args) {
        circle circle1 = new circle(3.0);
        circle circle2 = new circle(5.0);
        circle circle3 = new circle(5.0);

        System.out.println("circle1: " + circle1.toString());
        System.out.println("circle2: " + circle2.toString());

        circle1.setR(4.0);
        System.out.println("Радиус circle1 после setR = " + circle1.getR());
        System.out.println("Длина окружности circle2: " + circle2.Lcircle() + " Площадь окружности circle2: " + circle2.Scircle() + "\n");

        System.out.println("Сравнение 1 и 2 окружностей");
        circle1.srav(circle2);
        System.out.println("Сравнения 2 и 3 окружностей");
        circle2.srav(circle3);
    }
}
