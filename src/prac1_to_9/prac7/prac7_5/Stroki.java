package prac1_to_9.prac7.prac7_5;

class Stroki implements RabotaSoStrokoi {
    @Override
    public int StringCount(String s){
        if (IsNullorEmpty(s)) {
            return 0;
        }
        return s.length();
    }

    public String StringNechet(String s) {
        if (IsNullorEmpty(s)) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i<s.length(); i+=2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public String Stringinvert(String s) {
        if (IsNullorEmpty(s)) {
            return "";
        }
        return new StringBuilder(s).reverse().toString();
    }
}
