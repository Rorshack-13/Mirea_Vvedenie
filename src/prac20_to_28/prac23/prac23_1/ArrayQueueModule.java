package prac20_to_28.prac23.prac23_1;

import java.util.Arrays;

/**
 * Модульная реализация циклической очереди на массиве.
 * Инвариант:
 * - 0 <= size <= capacity
 * - front указывает на первый элемент, rear - на последний
 * - элементы хранятся в массиве в порядке следования с учётом зацикливания
 */
public class ArrayQueueModule {
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] elements = new Object[DEFAULT_CAPACITY];
    private static int front = -1;
    private static int rear = -1;
    private static int size = 0;

    // Предусловие: size < capacity
    // Постусловие: элемент добавлен в конец очереди, size увеличен
    public static void enqueue(Object element) {
        ensureCapacity();
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % elements.length;
        }
        elements[rear] = element;
        size++;
    }

    // Предусловие: size > 0
    // Постусловие: возвращён первый элемент, состояние не изменилось
    public static Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    // Предусловие: size > 0
    // Постусловие: первый элемент удалён и возвращён, size уменьшен
    public static Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = elements[front];
        elements[front] = null;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % elements.length;
        }
        size--;
        return result;
    }

    // Постусловие: возвращён текущий размер
    public static int size() {
        return size;
    }

    // Постусловие: возвращено true, если очередь пуста
    public static boolean isEmpty() {
        return size == 0;
    }

    // Постусловие: очередь очищена, size = 0
    public static void clear() {
        Arrays.fill(elements, null);
        front = -1;
        rear = -1;
        size = 0;
    }

    private static void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(front + i) % elements.length];
            }
            elements = newElements;
            front = 0;
            rear = size - 1;
        }
    }
}