package prac1_to_9.prac4.prac41_3;

public class test {
    public static void main(String[] args) {

        person person1 = new person();
        person person2 = new person("Эрдем", 19);

        person1.talk();
        person1.move();
        System.out.println();
        person2.move();
        person2.talk();

        System.out.println("Его зовут - " + person2.getFullName() + ", ему " + person2.getAge() + " лет");

    }
}
