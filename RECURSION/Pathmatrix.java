import java.util.Arrays;
import java.util.Scanner;

public class Pathmatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = true;
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // arr[i][j] = sc.nextBoolean();
        // }
        // }
        int[][] ans = new int[n][n];
        fun(arr, 0, 0, n, ans, 0);
    }

    public static void fun(boolean[][] arr, int r, int c, int n, int[][] ans, int count) {
        if (r == n - 1 && c == n - 1) {
            ans[r][c] = count;
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(ans[i]));
            }
            return;
        }
        if (!arr[r][c]) {
            return;
        }

        if (r > 0) {
            arr[r][c] = false;
            ans[r][c] = count;
            fun(arr, r - 1, c, n, ans, count + 1);
            ans[r][c] = 0;
            arr[r][c] = true;
        }
        if (c + 1 < n) {
            arr[r][c] = false;
            ans[r][c] = count;
            fun(arr, r, c + 1, n, ans, count + 1);
            ans[r][c] = 0;
            arr[r][c] = true;
        }
        if (c > 0) {
            arr[r][c] = false;
            ans[r][c] = count;
            fun(arr, r, c - 1, n, ans, count + 1);
            ans[r][c] = 0;
            arr[r][c] = true;
        }
        if (r + 1 < n) {
            arr[r][c] = false;
            ans[r][c] = count;
            fun(arr, r + 1, c, n, ans, count + 1);
            ans[r][c] = 0;
            arr[r][c] = true;
        }
    }
}
