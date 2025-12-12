package prac1_to_9.prac6.prac6_3;

class Car implements Nameable {
    private String name;
    private String mark;
    private int god;

    public Car(String name, String mark, int god) {
        this.name = name;
        this.mark = mark;
        this.god = god;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public int getGod() {
        return god;
    }
}
