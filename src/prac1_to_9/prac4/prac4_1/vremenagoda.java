package prac1_to_9.prac4.prac4_1;


public class vremenagoda {
    public static void main(String[] args) {
        season myFavoriteSeason = season.SUMMER;

        System.out.println("Мое любимое время года:");
        System.out.println("Название: " + myFavoriteSeason.getName());
        System.out.println("Средняя температура: " + myFavoriteSeason.getTemp() + "°C");
        System.out.println("Описание: " + myFavoriteSeason.getDescription() + "\n");

        printSeasonLove(myFavoriteSeason);

        // Вывод всех времен года
        System.out.println("\nВсе времена года:");
        for (season season : season.values()) {
            System.out.println(season.getName() + ": " +
                    season.getTemp() + "°C, " +
                    season.getDescription());
        }
    }

    public static void printSeasonLove(season season) {
        switch (season) {
            case WINTER -> System.out.println("Я люблю зиму");
            case SPRING -> System.out.println("Я люблю весну");
            case SUMMER -> System.out.println("Я люблю лето");
            case AUTUMN -> System.out.println("Я люблю осень");
        }
    }
}