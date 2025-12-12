package prac1_to_9.prac7.prac7_5;

public interface RabotaSoStrokoi {
    int StringCount(String s);

    String StringNechet(String s);

    String Stringinvert(String s);

    default boolean IsNullorEmpty(String s){
        return s == null || s.isEmpty();
    }
}
