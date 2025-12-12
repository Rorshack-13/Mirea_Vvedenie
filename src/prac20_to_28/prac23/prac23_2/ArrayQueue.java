package prac20_to_28.prac23.prac23_2;

import java.util.Arrays;

public class ArrayQueue extends AbstractQueue {
    private Object[] elements;
    private int front;
    private int rear;
    private final int initialCapacity;

    public ArrayQueue(int capacity) {
        super();
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.elements = new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.initialCapacity = capacity;
    }

    /**
     * Конструктор по умолчанию (ёмкость = 10).
     */
    public ArrayQueue() {
        this(10);
    }

    /**
     * Добавляет элемент в конец очереди.
     * Конкретная реализация для массива.
     */
    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        ensureCapacity();

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % elements.length;
        }

        elements[rear] = element;
        size++;  // увеличиваем размер из AbstractQueue
        afterEnqueue();  // вызываем хук
    }

    /**
     * Возвращает первый элемент без удаления.
     */
    @Override
    protected Object getFirstElementImpl() {
        return elements[front];
    }

    /**
     * Удаляет и возвращает первый элемент.
     */
    @Override
    protected Object removeFirstElementImpl() {
        Object result = elements[front];
        elements[front] = null;  // помогаем сборщику мусора

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % elements.length;
        }

        return result;
    }

    /**
     * Очищает очередь.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        front = -1;
        rear = -1;
        size = 0;  // сбрасываем размер
    }

    /**
     * Возвращает массив элементов.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                array[i] = elements[(front + i) % elements.length];
            }
        }

        return array;
    }

    /**
     * Возвращает текущую ёмкость массива.
     */
    public int capacity() {
        return elements.length;
    }

    /**
     * Обеспечивает достаточную ёмкость массива.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];

            if (!isEmpty()) {
                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[(front + i) % elements.length];
                }
            }

            elements = newElements;
            front = 0;
            rear = size - 1;
        }
    }
}