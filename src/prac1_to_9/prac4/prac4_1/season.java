package prac1_to_9.prac4.prac4_1;

public enum season {
    // 3. Перечисление содержит переменную со средней температурой
    // 4. Конструктор принимает среднюю температуру
    WINTER(-15.0,"Зима") {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SPRING(10.0,"Весна") {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SUMMER(30.0,"Лето") {
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN(8.0,"Осень") {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    };

    private final double temp;
    private final String name;

    season(double temp, String name) {
        this.temp = temp;
        this.name = name;
    }

    public abstract String getDescription();

    public double getTemp() {
        return temp;
    }

    public String getName() {
        return name;
    }
}
