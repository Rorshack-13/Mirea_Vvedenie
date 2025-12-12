package prac1_to_9.prac6.prac6_3;

class Animals implements Nameable {
    private String name;
    private String vid;
    private int age;

    public Animals(String name, String vid, int age) {
        this.name = name;
        this.vid = vid;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getVid() {
        return vid;
    }

    public int getAge() {
        return age;
    }
}
