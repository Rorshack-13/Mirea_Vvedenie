package prac10_to_19.prac18.prac18_5;

public class ThrowsDemo {
    public void getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
        } catch (NullPointerException e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        ThrowsDemo obj = new ThrowsDemo();
        obj.getDetails(null);
    }
}
