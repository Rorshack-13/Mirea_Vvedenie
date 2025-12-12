package prac20_to_28.prac20.prac20_1_2;

public class Generic<T, V, K> {
    private T t;
    private V v;
    private K k;

    public Generic(T t, V v, K k) {
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

    public static void main(String[] args) {
        Generic<String, Integer, Double> example = new Generic<>("Hello", 123, 45.67);
        example.printTypes();
    }
}