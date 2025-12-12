package prac1_to_9.prac4.prac41_3;

public class person {
    private String fullName;
    private int age;

    public person(String fullName, int age) {
        this.age = age;
        this.fullName = fullName;
    }

    public person() {
        this("нет имени", 0);
    }

    public String getFullName() {return fullName;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public void setFullName(String fullName) {this.fullName = fullName;}

    public void move() {
        System.out.println(fullName + " двигается");
    }

    public void talk() {
        System.out.println(fullName + " говорит");
    }

}