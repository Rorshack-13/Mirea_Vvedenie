package prac20_to_28.prac21.prac21_2_3;

import java.lang.reflect.Array;

public class Universal<T> {
    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Universal(Class<T> type, int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = (T[]) Array.newInstance(type, capacity);
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public Universal(T[] sourceArray) {
        this.capacity = sourceArray.length * 2;
        this.array = (T[]) new Object[capacity];
        System.arraycopy(sourceArray, 0, this.array, 0, sourceArray.length);
        this.size = sourceArray.length;
    }

    public void add(T element) {
        if (size >= capacity) {
            resize();
        }
        array[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        return array[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        array[index] = element;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }

        T removedElement = array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        return removedElement;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> type) {
        T[] result = (T[]) Array.newInstance(type, size);
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Тестирование ===");

        System.out.println("\n1. Массив строк:");
        Universal<String> stringArray = new Universal<>(String.class, 5);
        stringArray.add("Hello");
        stringArray.add("World");
        stringArray.add("Java");
        stringArray.add("Generics");
        System.out.println("Содержимое: " + stringArray);
        System.out.println("Размер: " + stringArray.size());
        System.out.println("Элемент с индексом 2: " + stringArray.get(2));

        System.out.println("\n2. Массив целых чисел:");
        Universal<Integer> intArray = new Universal<>(Integer.class, 3);
        intArray.add(100);
        intArray.add(200);
        intArray.add(300);
        intArray.add(400);
        System.out.println("Содержимое: " + intArray);
        System.out.println("Вместимость: " + intArray.capacity());
        System.out.println("Элемент с индексом 1: " + intArray.get(1));

        System.out.println("\n3. Массив дробных чисел:");
        Universal<Double> doubleArray = new Universal<>(Double.class, 2);
        doubleArray.add(3.14);
        doubleArray.add(2.71);
        Double x = doubleArray.get(1);
        System.out.println("Взяли элемент с индексом 1:" + x);
        System.out.println("Содержимое: " + doubleArray);
        System.out.println("Элемент с индексом 0: " + doubleArray.get(0));

        System.out.println("\n4. Разные типы данных:");
        Universal<Number> numberArray = new Universal<>(Number.class, 10);
        numberArray.add(42);    // Integer
        numberArray.add(3.14159);   // Double
        numberArray.add(100L);   // Long
        numberArray.add(3.14f);  // Float
        System.out.println("Смешанные числа: " + numberArray);
        System.out.println("Элемент с индексом 2: " + numberArray.get(2));

        System.out.println("\n5. Удаление и изменение:");
        Universal<String> testArray = new Universal<>(String.class, 5);
        testArray.add("A");
        testArray.add("B");
        testArray.add("C");
        testArray.add("D");
        System.out.println("До удаления: " + testArray);

        testArray.remove(1); // Удаляем "B"
        System.out.println("После удаления индекса 1: " + testArray);

        testArray.set(0, "Z"); // Меняем "A" на "Z"
        System.out.println("После изменения индекса 0: " + testArray);

        System.out.println("\n6. Поиск элементов:");
        System.out.println("Содержит 'C'? " + testArray.contains("C"));
        System.out.println("Содержит 'X'? " + testArray.contains("X"));

        System.out.println("\n7. Очистка массива:");
        testArray.clear();
        System.out.println("После очистки: " + testArray);
        System.out.println("Пустой? " + testArray.isEmpty());
    }
}