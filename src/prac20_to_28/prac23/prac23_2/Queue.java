package prac20_to_28.prac23.prac23_2;

public interface Queue {
    void enqueue(Object element);
    Object element();
    Object dequeue();
    int size();
    boolean isEmpty();
    void clear();
    Object[] toArray();
}