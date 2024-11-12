import java.util.Arrays;
import java.util.Scanner;

public class Nqueens {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        dfs(arr, 0, n);
        System.out.println(count);
    }

    public static void dfs(int[][] arr, int r, int n) {
        if (r == n) {
            count += 1;
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (issafe(arr, r, i)) {
                arr[r][i] = 1;
                dfs(arr, r + 1, n);
                arr[r][i] = 0;
            }
        }

    }

    public static boolean issafe(int[][] arr, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (arr[i][c] == 1) {
                return false;
            }

        }
        int max_left = Math.min(r, c);
        for (int i = 1; i <= max_left; i++) {
            if (arr[r - i][c - i] == 1) {
                return false;
            }
        }
        int max_right = Math.min(r, arr.length - c - 1);
        for (int i = 1; i <= max_right; i++) {
            if (arr[r - i][c + i] == 1) {
                return false;
            }
        }
        return true;
    }
}
