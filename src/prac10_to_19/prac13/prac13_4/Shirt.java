package prac10_to_19.prac13.prac13_4;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public static Shirt fromString(String shirtData) {
        String[] parts = shirtData.split(",");
        if (parts.length == 4) {
            return new Shirt(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Информация о рубашке:\n" +
                "  ID: " + id + "\n" +
                "  Описание: " + description + "\n" +
                "  Цвет: " + color + "\n" +
                "  Размер: " + size + "\n";
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getColor() { return color; }
    public String getSize() { return size; }
}