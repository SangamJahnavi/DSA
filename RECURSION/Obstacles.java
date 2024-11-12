import java.util.Scanner;

public class Obstacles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextBoolean();
            }
        }
        fun("", arr, 0, 0, n);
    }

    public static void fun(String p, boolean[][] arr, int r, int c, int n) {
        if (r == n - 1 && c == n - 1) {
            System.out.println(p);
            return;
        }
        if (arr[r][c] == false) {
            return;
        }
        if (c + 1 < n) {
            fun(p + "r", arr, r, c + 1, n);
        }
        if (r + 1 < n) {
            fun(p + "d", arr, r + 1, c, n);
        }
    }
}
