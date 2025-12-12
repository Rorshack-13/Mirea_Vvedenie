package prac20_to_28.prac20.prac20_3;

import java.io.Serializable;

public class Generic3<T extends Comparable<T>, V extends Animal & Serializable, K extends Animal> {
    private T t;
    private V v;
    private K k;

    public Generic3(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printTypes() {
        System.out.println("Type of T: " + t.getClass().getName());
        System.out.println("Type of V: " + v.getClass().getName());
        System.out.println("Type of K: " + k.getClass().getName());
    }

    public void printAnimalInfo() {
        System.out.println("\nИнформация о животных:");
        System.out.println("V: " + v.getName() + " (" + v.getClass().getSimpleName() + ")");
        v.makeSound();

        System.out.println("K: " + k.getName() + " (" + k.getClass().getSimpleName() + ")");
        k.makeSound();
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Шарик", 5);
        Cat cat = new Cat("Рыжик", 3);

        Generic3<String, Dog, Cat> example = new Generic3<>("Hello", dog, cat);

        example.printTypes();
        example.printAnimalInfo();
    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();
}

class Dog extends Animal implements Serializable {
    private int age;

    public Dog(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит: Гав!");
    }
}

class Cat extends Animal {
    private int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит: Мяу!");
    }
}