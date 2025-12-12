package prac1_to_9.prac4.prac41_10;

abstract class Transport {
    protected String name;
    protected double speed;
    protected double costPerKm; // стоимость за км
    protected double capacity; // грузоподъемность в тоннах
    protected int passengerCapacity; // вместимость пассажиров

    public Transport(String name, double speed, double costPerKm, double capacity, int passengerCapacity) {
        this.name = name;
        this.speed = speed;
        this.costPerKm = costPerKm;
        this.capacity = capacity;
        this.passengerCapacity = passengerCapacity;
    }

    // Абстрактные методы для перевозки
    public abstract double calculateTime(double distance);
    public abstract double calculatePassengerCost(double distance, int passengers);
    public abstract double calculateCargoCost(double distance, double weight);

    // Метод для проверки возможности перевозки
    public boolean canTransportPassengers(int passengers) {
        return passengers <= passengerCapacity;
    }

    public boolean canTransportCargo(double weight) {
        return weight <= capacity;
    }

    public String getName() {
        return name;
    }
}

// Подкласс Автомобиль
class Car extends Transport {
    public Car() {
        super("Автомобиль", 80, 15, 2, 4);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed; // время в часах
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        if (!canTransportPassengers(passengers)) {
            System.out.println("Автомобиль не может перевезти " + passengers + " пассажиров (макс: " + passengerCapacity + ")");
            return -1;
        }
        return distance * costPerKm;
    }

    @Override
    public double calculateCargoCost(double distance, double weight) {
        if (!canTransportCargo(weight)) {
            System.out.println("Автомобиль не может перевезти " + weight + " тонн (макс: " + capacity + ")");
            return -1;
        }
        return distance * costPerKm * (1 + weight / 2); // стоимость увеличивается с весом
    }
}

// Подкласс Самолет
class Airplane extends Transport {
    public Airplane() {
        super("Самолет", 800, 50, 20, 150);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed + 1.5;
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        if (!canTransportPassengers(passengers)) {
            System.out.println("Самолет не может перевезти " + passengers + " пассажиров (макс: " + passengerCapacity + ")");
            return -1;
        }
        return distance * costPerKm * passengers;
    }

    @Override
    public double calculateCargoCost(double distance, double weight) {
        if (!canTransportCargo(weight)) {
            System.out.println("Самолет не может перевезти " + weight + " тонн (макс: " + capacity + ")");
            return -1;
        }
        return distance * costPerKm * weight;
    }
}

// Подкласс Поезд
class Train extends Transport {
    public Train() {
        super("Поезд", 120, 8, 500, 300);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed + 0.5;
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        if (!canTransportPassengers(passengers)) {
            System.out.println("Поезд не может перевезти " + passengers + " пассажиров (макс: " + passengerCapacity + ")");
            return -1;
        }
        return distance * costPerKm * passengers;
    }

    @Override
    public double calculateCargoCost(double distance, double weight) {
        if (!canTransportCargo(weight)) {
            System.out.println("Поезд не может перевезти " + weight + " тонн (макс: " + capacity + ")");
            return -1;
        }
        return distance * costPerKm * weight;
    }
}

// Подкласс Корабль
class Ship extends Transport {
    public Ship() {
        super("Корабль", 40, 5, 1000, 200);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed + 4; // + время погрузки/разгрузки
    }

    @Override
    public double calculatePassengerCost(double distance, int passengers) {
        if (!canTransportPassengers(passengers)) {
            System.out.println("Корабль не может перевезти " + passengers + " пассажиров (макс: " + passengerCapacity + ")");
            return -1;
        }
        return distance * costPerKm * passengers;
    }

    @Override
    public double calculateCargoCost(double distance, double weight) {
        if (!canTransportCargo(weight)) {
            System.out.println("Корабль не может перевезти " + weight + " тонн (макс: " + capacity + ")");
            return -1;
        }
        return distance * costPerKm * weight;
    }
}

// Класс для тестирования
public class TransportDemo {
    public static void main(String[] args) {
        // Создаем транспортные средства
        Transport[] transports = {
                new Car(),
                new Airplane(),
                new Train(),
                new Ship()
        };

        double distance = 400;
        int passengers = 4;
        double cargoWeight = 10;

        System.out.println("Расстояние: " + distance + " км");
        System.out.println("Пассажиры: " + passengers);
        System.out.println("Груз: " + cargoWeight + " тонн\n");

        for (Transport transport : transports) {
            System.out.println("=== " + transport.getName() + " ===");

            // Расчет времени
            double time = transport.calculateTime(distance);
            System.out.printf("Время в пути: %.2f часов (%.2f дней)%n",
                    time, time / 24);

            // Расчет стоимости перевозки пассажиров
            double passengerCost = transport.calculatePassengerCost(distance, passengers);
            if (passengerCost >= 0) {
                System.out.printf("Стоимость перевозки пассажиров: %.2f руб.%n", passengerCost);
            }

            // Расчет стоимости перевозки груза
            double cargoCost = transport.calculateCargoCost(distance, cargoWeight);
            if (cargoCost >= 0) {
                System.out.printf("Стоимость перевозки груза: %.2f руб.%n", cargoCost);
            }

            System.out.println();
        }

        // Дополнительный пример с большим количеством пассажиров
        System.out.println("=== Пример с 8 пассажирами ===");
        Transport car = new Car();
        double cost = car.calculatePassengerCost(distance, 8);
        if (cost < 0) {
            System.out.println("Автомобиль не подходит для 8 пассажиров");
        }
    }
}