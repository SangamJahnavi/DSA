import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        permutation("", "123");
        System.out.println(fun("", "abc"));
        ArrayList<String> l = new ArrayList<>();
        System.out.println(fun1("", "abc", l));
        System.out.println(count("", "abc"));
        System.out.println(coun("", "abc"));
    }

    public static void permutation(String p, String up) {
        if (up.isEmpty()) {
            // System.out.println(p);
            return;
        }
        for (int i = 0; i < p.length() + 1; i++) {
            permutation(p.substring(0, i) + up.charAt(0) + p.substring(i, p.length()), up.substring(1));
            System.out.println(p);
        }
    }

    public static ArrayList<String> fun(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> k = new ArrayList<>();
            k.add(p);
            return k;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < p.length() + 1; i++) {
            ans.addAll(fun(p.substring(0, i) + up.charAt(0) + p.substring(i, p.length()), up.substring(1)));
        }
        return ans;
    }

    public static ArrayList<String> fun1(String p, String up, ArrayList<String> l) {
        if (up.isEmpty()) {
            l.add(p);
            return l;
        }
        for (int i = 0; i < p.length() + 1; i++) {
            fun1(p.substring(0, i) + up.charAt(0) + p.substring(i), up.substring(1), l);
        }
        return l;
    }

    public static int coun(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < p.length() + 1; i++) {
            count += coun(p.substring(0, i) + up.charAt(0) + p.substring(i, p.length()), up.substring(1));
        }
        return count;
    }

    static int c = 0;

    public static int count(String p, String up) {
        if (up.isEmpty()) {
            c += 1;
            System.out.println(p);
            return c;
        }
        for (int i = 0; i < p.length() + 1; i++) {
            count(p.substring(0, i) + up.charAt(0) + p.substring(i, p.length()), up.substring(1));
        }
        return c;
    }
}
