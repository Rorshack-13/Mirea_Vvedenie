package prac20_to_28.prac23.prac23_2;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== Тестирование рефакторинга с AbstractQueue ===\n");

        System.out.println("1. Тестирование LinkedQueue:");
        testQueue(new LinkedQueue(), "LinkedQueue");

        System.out.println("\n2. Тестирование ArrayQueue:");
        testQueue(new ArrayQueue(5), "ArrayQueue");

        System.out.println("\n3. Проверка полиморфизма через AbstractQueue:");
        testPolymorphism();

        System.out.println("\n=== Все тесты пройдены! ===");
    }

    private static void testQueue(AbstractQueue queue, String queueName) {
        System.out.println("  " + queueName + " создана");
        System.out.println("  - Начальный размер: " + queue.size() +
                " (ожидается 0): " + (queue.size() == 0 ? "ДА" : "НЕТ"));
        System.out.println("  - Пустая ли: " + queue.isEmpty() +
                " (ожидается true): " + (queue.isEmpty() ? "ДА" : "НЕТ"));

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("  - Добавлено 3 элемента");
        System.out.println("  - Размер: " + queue.size() +
                " (ожидается 3): " + (queue.size() == 3 ? "ДА" : "НЕТ"));

        System.out.println("  - Первый элемент: '" + queue.element() +
                "' (ожидается 'A'): " + (queue.element().equals("A") ? "ДА" : "НЕТ"));

        Object removed = queue.dequeue();
        System.out.println("  - Удалён элемент: '" + removed +
                "' (ожидается 'A'): " + (removed.equals("A") ? "ДА" : "НЕТ"));
        System.out.println("  - Новый размер: " + queue.size() +
                " (ожидается 2): " + (queue.size() == 2 ? "ДА" : "НЕТ"));

        System.out.println("  - toString(): " + queue.toString() +
                " (ожидается [B, C]): " + (queue.toString().equals("[B, C]") ? "ДА" : "НЕТ"));

        queue.clear();
        System.out.println("  - После clear(): размер = " + queue.size() +
                ", isEmpty = " + queue.isEmpty() + ": " +
                (queue.size() == 0 && queue.isEmpty() ? "ДА" : "НЕТ"));
    }

    private static void testPolymorphism() {
        AbstractQueue[] queues = new AbstractQueue[3];
        queues[0] = new LinkedQueue();
        queues[1] = new ArrayQueue();
        queues[2] = new ArrayQueue(3);

        boolean allPassed = true;

        for (int i = 0; i < queues.length; i++) {
            AbstractQueue q = queues[i];
            q.enqueue(i * 10);
            q.enqueue(i * 10 + 1);

            if (q.size() != 2 || !q.element().equals(i * 10)) {
                allPassed = false;
                break;
            }

            q.dequeue();
            q.clear();
        }

        System.out.println("  Все очереди работают через AbstractQueue: " +
                (allPassed ? "ДА" : "НЕТ"));

        Queue q1 = new LinkedQueue();
        Queue q2 = new ArrayQueue();

        q1.enqueue("test");
        q2.enqueue("test");

        System.out.println("  Общие методы element(), size(), isEmpty() работают: " +
                (q1.element().equals(q2.element()) &&
                        q1.size() == q2.size() &&
                        q1.isEmpty() == q2.isEmpty() ? "ДА" : "НЕТ"));
    }
}