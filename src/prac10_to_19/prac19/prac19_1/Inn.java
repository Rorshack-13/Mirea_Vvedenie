package prac10_to_19.prac19.prac19_1;

public class Inn {
    private String name;
    private String inn;

    public Inn(String name, String inn) {
        this.name = name;
        this.inn = inn;
    }

    public String getName() {return name;}
    public String getInn() {return inn;}
    public void setName(String name) {this.name = name;}
    public void setInn(String inn) {this.inn = inn;}

    @Override
    public String toString() {
        return name + " - " + inn;
    }
}
