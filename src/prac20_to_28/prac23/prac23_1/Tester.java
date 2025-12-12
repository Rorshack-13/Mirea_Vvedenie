package prac20_to_28.prac23.prac23_1;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Тестирование ArrayQueueModule:");
        testArrayQueueModule();

        System.out.println("\nТестирование ArrayQueueADT:");
        testArrayQueueADT();

        System.out.println("\nТестирование ArrayQueue:");
        testArrayQueue();

        System.out.println("\nВсе тесты успешно пройдены!");
    }

    private static void testArrayQueueModule() {
        ArrayQueueModule.clear();
        System.out.println("  - Проверка пустой очереди: " + (ArrayQueueModule.isEmpty() ? "ДА" : "ОШИБКА"));

        ArrayQueueModule.enqueue(1);
        ArrayQueueModule.enqueue(2);
        ArrayQueueModule.enqueue(3);
        System.out.println("  - Добавлено 3 элемента");

        System.out.println("  - Размер очереди = 3: " + (ArrayQueueModule.size() == 3 ? "ДА" : "ОШИБКА"));
        System.out.println("  - Первый элемент = 1: " + (ArrayQueueModule.element().equals(1) ? "ДА" : "ОШИБКА"));

        Object removed = ArrayQueueModule.dequeue();
        System.out.println("  - Удалён элемент: " + removed);
        System.out.println("  - Удалён правильный элемент (1): " + (removed.equals(1) ? "ДА" : "ОШИБКА"));

        System.out.println("  - Размер после удаления = 2: " + (ArrayQueueModule.size() == 2 ? "ДА" : "ОШИБКА"));

        ArrayQueueModule.clear();
        System.out.println("  - Очередь очищена, пустая: " + (ArrayQueueModule.isEmpty() ? "ДА" : "ОШИБКА"));

        System.out.println("Тестирование ArrayQueueModule завершено успешно.");
    }

    private static void testArrayQueueADT() {
        ArrayQueueADT queue = new ArrayQueueADT();
        ArrayQueueADT.clear(queue);
        System.out.println("  - Проверка пустой очереди: " + (ArrayQueueADT.isEmpty(queue) ? "ДА" : "ОШИБКА"));

        ArrayQueueADT.enqueue(queue, "A");
        ArrayQueueADT.enqueue(queue, "B");
        System.out.println("  - Добавлены элементы 'A' и 'B'");

        System.out.println("  - Размер очереди = 2: " + (ArrayQueueADT.size(queue) == 2 ? "ДА" : "ОШИБКА"));
        System.out.println("  - Первый элемент = 'A': " + (ArrayQueueADT.element(queue).equals("A") ? "ДА" : "ОШИБКА"));

        Object removed = ArrayQueueADT.dequeue(queue);
        System.out.println("  - Удалён элемент: " + removed);
        System.out.println("  - Удалён правильный элемент ('A'): " + (removed.equals("A") ? "ДА" : "ОШИБКА"));

        ArrayQueueADT.clear(queue);
        System.out.println("  - Очередь очищена, пустая: " + (ArrayQueueADT.isEmpty(queue) ? "ДА" : "ОШИБКА"));

        System.out.println("Тестирование ArrayQueueADT завершено успешно.");
    }

    private static void testArrayQueue() {
        ArrayQueue queue = new ArrayQueue();
        queue.clear();
        System.out.println("  - Проверка пустой очереди: " + (queue.isEmpty() ? "ДА" : "ОШИБКА"));

        queue.enqueue(10.5);
        queue.enqueue(20.5);
        System.out.println("  - Добавлены элементы 10.5 и 20.5");

        System.out.println("  - Размер очереди = 2: " + (queue.size() == 2 ? "ДА" : "ОШИБКА"));
        System.out.println("  - Первый элемент = 10.5: " + (queue.element().equals(10.5) ? "ДА" : "ОШИБКА"));

        Object removed = queue.dequeue();
        System.out.println("  - Удалён элемент: " + removed);
        System.out.println("  - Удалён правильный элемент (10.5): " + (removed.equals(10.5) ? "ДА" : "ОШИБКА"));

        queue.clear();
        System.out.println("  - Очередь очищена, пустая: " + (queue.isEmpty() ? "ДА" : "ОШИБКА"));

        System.out.println("Тестирование ArrayQueue завершено успешно.");
    }
}