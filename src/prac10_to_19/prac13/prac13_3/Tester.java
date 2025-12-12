package prac10_to_19.prac13.prac13_3;

public class Tester {
    public static void main(String[] args) {
        String[] testAddresses = {
                "Россия, Московская область, Москва, Тверская улица, 15, 2, 45",
                "Беларусь. Минская область. Минск. Ленина проспект. 25. . 12",
                "США-Калифорния-Лос-Анджелес-Сансет бульвар-100-1-305",
                "Украина, Киевская область; Киев, Крещатик, 10, 3, 78"
        };

        System.out.println("=== Тестирование метода с разделителем-запятой ===");
        for (int i = 0; i < testAddresses.length; i++) {
            Adress addr = new Adress();
            addr.parseAddA(testAddresses[i]);
            System.out.println((i + 1) + ". " + addr);
        }

        System.out.println("\n=== Тестирование метода с любым разделителем ===");
        for (int i = 0; i < testAddresses.length; i++) {
            Adress addr = new Adress();
            addr.parseAddB(testAddresses[i]);
            System.out.println((i + 1) + ". " + addr);
        }
    }
}