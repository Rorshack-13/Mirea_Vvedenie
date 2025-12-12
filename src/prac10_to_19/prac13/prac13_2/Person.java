package prac10_to_19.prac13.prac13_2;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Person(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public Person(String lastName) {
        this(lastName, null, null);
    }

    public String getFullName() {
        StringBuilder result = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
        }
        else {
            return "Фамилия должна быть обязательно! ";
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(firstName.charAt(0)).append('.');
        }

        // Обработка отчества
        if (middleName != null && !middleName.isEmpty()) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(middleName.charAt(0)).append('.');
        }

        return result.toString();
    }

    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}
    public String getMiddleName() {return middleName;}

    @Override
    public String toString() {
        return getFullName();
    }

}
