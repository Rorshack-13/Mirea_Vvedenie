package prac20_to_28.prac23.prac23_2;

public class LinkedQueue extends AbstractQueue {
    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public LinkedQueue() {
        super();
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Node newNode = new Node(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        afterEnqueue();
    }

    @Override
    protected Object getFirstElementImpl() {
        return head.value;
    }

    @Override
    protected Object removeFirstElementImpl() {
        Object result = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return result;
    }

    @Override
    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.value = null;
            current.next = null;
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    @Override
    protected void afterDequeue() {
        if (isEmpty()) {
            tail = null;
        }
    }
}
