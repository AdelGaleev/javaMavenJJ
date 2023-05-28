package lesson18;

public class ParametrizeMethod {
    public static void main(String[] args) {
        ParamMethod method = new ParamMethod();
        method.print("qwe", 123);
    }
}
class ParamMethod {
    private int i = 0;

    public <K,V> void print (K key, V value) {
        System.out.println(key + " " + value);
    }
}
