package prac10_to_19.prac13.prac13_3;

import java.util.StringTokenizer;

public class Adress {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String buildings;
    private String apartments;

    public Adress() {};

    public String getCountry() {return country;}
    public String getRegion() {return region;}
    public String getCity() {return city;}
    public String getStreet() {return street;}
    public String getHouse() {return house;}
    public String getBuildings() {return buildings;}
    public String getApartments() {return apartments;}

    @Override
    public String toString() {
        return String.format("Адрес: %s, %s, %s, %s, %s, %s, %s",
                country, region, city, street, house, buildings, apartments);
    }

    public void parseAddA(String address) {
        if (address == null || address.isEmpty()) return;

        String[] parts = address.split(",");
        setAddressParts(parts);
    }

    public void parseAddB(String address) {
        if (address == null || address.isEmpty()) return;

        StringTokenizer tokenizer = new StringTokenizer(address, ",.;-");
        String[] parts = new String[tokenizer.countTokens()];

        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            parts[index++] = tokenizer.nextToken().trim();
        }

        setAddressParts(parts);
    }

    private void setAddressParts(String[] parts) {
        if (parts.length > 0) country = parts[0].trim();
        if (parts.length > 1) region = parts[1].trim();
        if (parts.length > 2) city = parts[2].trim();
        if (parts.length > 3) street = parts[3].trim();
        if (parts.length > 4) house = parts[4].trim();
        if (parts.length > 5) buildings = parts[5].trim();
        if (parts.length > 6) apartments = parts[6].trim();
    }
}