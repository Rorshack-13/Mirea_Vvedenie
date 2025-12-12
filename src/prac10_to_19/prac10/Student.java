package prac10_to_19.prac10;

public class Student {
    private String name;
    private String surname;
    private String speciality;
    private int group;
    private int course;
    private double gpa;

    public Student(String name, String surname, String speciality, int group, int course, double gpa) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.group = group;
        this.course = course;
        this.gpa = gpa;
    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getSpeciality() {return speciality;}
    public int getGroup() {return group;}
    public int getCourse() {return course;}
    public double getGpa() {return gpa;}

    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setSpeciality(String speciality) {this.speciality = speciality;}
    public void setGroup(int group) {this.group = group;}
    public void setCourse(int course) {this.course = course;}
    public void setGpa(double gpa) {this.gpa = gpa;}

    @Override
    public String toString() {
        return String.format("Имя: %-10s  Фамилия: %-10s Специальность: %-10s Курс: %-2d \t Группа: %-6s \t GPA: %.2f\",\n", name, surname,speciality,course,group,gpa);
    }
}
