import java.util.*;

public class Countingpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(counts(0, 0, n - 1));
    }

    public static int counts(int r, int c, int n) {
        if (r == n || c == n) {
            return 1;
        }
        int rc = counts(r + 1, c, n);
        int lc = counts(r, c + 1, n);
        return rc + lc;
    }
}
