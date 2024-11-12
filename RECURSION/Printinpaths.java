import java.util.*;

public class Printinpaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> l = new ArrayList<>();
        // System.out.println(counts(0, 0, n - 1));
        System.out.println(fun("", 0, 0, n, l));
        System.out.println(l.size());
    }

    public static ArrayList<String> fun(String s, int r, int c, int n, ArrayList<String> l) {
        if (r == n - 1 && c == n - 1) {
            l.add(s);
            return l;
        }
        if (r < n) {
            fun(s + "r", r + 1, c, n, l);
        }
        if (c < n) {

            fun(s + "d", r, c + 1, n, l);
        } // l1.addAll(l2);
        return l;
    }
}
