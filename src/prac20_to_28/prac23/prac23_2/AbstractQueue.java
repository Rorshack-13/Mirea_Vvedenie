package prac20_to_28.prac23.prac23_2;

import java.util.NoSuchElementException;

/**
 * Абстрактный базовый класс для всех реализаций очереди.
 * Выносит общую логику, которая одинакова для всех очередей.
 */
public abstract class AbstractQueue implements Queue {
    protected int size;

    protected AbstractQueue() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return getFirstElementImpl();  // делегируем конкретной реализации
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object result = removeFirstElementImpl();
        size--;
        afterDequeue();
        return result;
    }

    @Override
    public String toString() {
        Object[] array = toArray();
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public abstract void enqueue(Object element);

    @Override
    public abstract void clear();

    @Override
    public abstract Object[] toArray();

    protected abstract Object getFirstElementImpl();

    protected abstract Object removeFirstElementImpl();

    protected void afterDequeue() {
    }

    protected void afterEnqueue(){

    }
}