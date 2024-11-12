import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
        fun("", "abc");
        System.out.println(fun1("", "abc"));
    }

    public static void fun(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        fun(p + up.charAt(0), up.substring(1));
        fun(p, up.substring(1));
    }

    public static ArrayList<String> fun1(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> k = new ArrayList<>();
            k.add(p);
            return k;
        }
        ArrayList<String> left = fun1(p + up.charAt(0), up.substring(1));
        ArrayList<String> right = fun1(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
