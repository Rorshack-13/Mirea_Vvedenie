package prac1_to_9.prac6.prac6_3;

class People implements Nameable {
    private String name;
    private String pol;
    private int age;

    public People(String name, String pol, int age) {
        this.name = name;
        this.pol = pol;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPol() {
        return pol;
    }

    public int getAge() {
        return age;
    }
}