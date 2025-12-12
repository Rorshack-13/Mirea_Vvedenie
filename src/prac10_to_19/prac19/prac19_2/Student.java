package prac10_to_19.prac19.prac19_2;

public class Student {
    private String Name;
    private String Surname;
    private String Major;
    private int Course;
    private int Group;
    private double GPA;

    public Student(String Name, String Surname, String Major, int Course, int Group, double GPA) {
        this.Name = Name;
        this.Surname = Surname;
        this.Major = Major;
        this.Course = Course;
        this.Group = Group;
        this.GPA = GPA;
    }

    public int getCourse() {return Course;}
    public int getGroup() {return Group;}
    public String getMajor() {return Major;}
    public String getName() {return Name;}
    public String getSurname() {return Surname;}
    public double getGPA() {return GPA;}

    public void setCourse(int course) {Course = course;}
    public void setGroup(int group) {Group = group;}
    public void setMajor(String major) {Major = major;}
    public void setName(String name) {Name = name;}
    public void setSurname(String surname) {Surname = surname;}
    public void setGPA(double GPA) {this.GPA = GPA;}

    @Override
    public String toString() {
        return String.format("Name: %-10s  Surname: %-10s Major: %-15s Course: %-2d \t\t Group: %-6s \t\t GPA: %.2f",
                Name, Surname, Major, Course, Group, GPA);
    }
}
