package prac1_to_9.prac2.prac2_1;

public class author {
    private String name;
    private String email;
    private char gender;

    public author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }


    public String getName() {return name;}

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email;}

    public  char getGender() {return gender;}

    @Override
    public String toString() {
        return "Name = " + name + "\n" + "Email = " + email + "\n" + "Gender = " + gender +"\n";
    }
}
