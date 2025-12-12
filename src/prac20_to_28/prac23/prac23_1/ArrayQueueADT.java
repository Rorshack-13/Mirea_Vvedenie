package prac20_to_28.prac23.prac23_1;

import java.util.Arrays;

/**
 * ADT-реализация циклической очереди на массиве.
 * Инвариант:
 * - 0 <= size <= capacity
 * - front указывает на первый элемент, rear - на последний
 * - элементы хранятся в массиве в порядке следования с учётом зацикливания
 */
public class ArrayQueueADT {
    private Object[] elements;
    private int front;
    private int rear;
    private int size;
    private final int initialCapacity;

    public ArrayQueueADT(int capacity) {
        this.elements = new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.initialCapacity = capacity;
    }

    public ArrayQueueADT() {
        this(10);
    }

    // Предусловие: size < capacity
    // Постусловие: элемент добавлен в конец очереди, size увеличен
    public static void enqueue(ArrayQueueADT queue, Object element) {
        ensureCapacity(queue);
        if (isEmpty(queue)) {
            queue.front = 0;
            queue.rear = 0;
        } else {
            queue.rear = (queue.rear + 1) % queue.elements.length;
        }
        queue.elements[queue.rear] = element;
        queue.size++;
    }

    // Предусловие: size > 0
    // Постусловие: возвращён первый элемент, состояние не изменилось
    public static Object element(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.elements[queue.front];
    }

    // Предусловие: size > 0
    // Постусловие: первый элемент удалён и возвращён, size уменьшен
    public static Object dequeue(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = queue.elements[queue.front];
        queue.elements[queue.front] = null;
        if (queue.front == queue.rear) {
            queue.front = -1;
            queue.rear = -1;
        } else {
            queue.front = (queue.front + 1) % queue.elements.length;
        }
        queue.size--;
        return result;
    }

    // Постусловие: возвращён текущий размер
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Постусловие: возвращено true, если очередь пуста
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // Постусловие: очередь очищена, size = 0
    public static void clear(ArrayQueueADT queue) {
        Arrays.fill(queue.elements, null);
        queue.front = -1;
        queue.rear = -1;
        queue.size = 0;
    }

    private static void ensureCapacity(ArrayQueueADT queue) {
        if (queue.size == queue.elements.length) {
            Object[] newElements = new Object[queue.elements.length * 2];
            for (int i = 0; i < queue.size; i++) {
                newElements[i] = queue.elements[(queue.front + i) % queue.elements.length];
            }
            queue.elements = newElements;
            queue.front = 0;
            queue.rear = queue.size - 1;
        }
    }
}
