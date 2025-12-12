package prac10_to_19.prac18.prac18_6;

public class ThrowsDemo2 {
    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println( message );
        }
        catch (NullPointerException e) {
            System.out.println("error " + e.getMessage());
        }

    }

    public String getDetails(String key) {
        if(key == null) {
            throw new NullPointerException( "null key in getDetails" );
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo2 obj = new ThrowsDemo2();
        obj.printMessage(null);
    }
}
