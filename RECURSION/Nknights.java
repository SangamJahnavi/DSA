import java.util.Arrays;
import java.util.Scanner;

public class Nknights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        dfs(arr, 0, 0, 0, n);
    }

    public static void dfs(int[][] arr, int r, int c, int count, int n) {
        if (count == n) {
            // arr[r][c] = 1;
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            // arr[r][c] = 0;
            System.out.println();
            return;
        }
        if (r == n - 1 && c == n) {
            return;
        }
        if (c == n) {
            dfs(arr, r + 1, 0, count, n);
        }
        if (issafe(arr, r, c)) {
            arr[r][c] = 1;
            dfs(arr, r, c + 1, count + 1, n);
            arr[r][c] = 0;
        }
        dfs(arr, r, c + 1, count, n);

    }

    public static boolean issafe(int[][] arr, int r, int c) {

        if (isvalid(arr, r - 1, c + 2) && arr[r - 1][c + 2] == 1) {
            return false;
        }
        if (isvalid(arr, r - 1, c - 2) && arr[r - 1][c - 2] == 1) {
            return false;
        }
        if (isvalid(arr, r - 2, c + 1) && arr[r - 2][c + 1] == 1) {
            return false;
        }
        if (isvalid(arr, r - 2, c - 1) && arr[r - 2][c - 1] == 1) {
            return false;
        }
        return true;
    }

    public static boolean isvalid(int[][] arr, int r, int c) {
        if (r >= 0 && r < arr.length && c >= 0 && c < arr.length && arr[r][c] == 0) {
            return true;
        }
        return false;
    }
}
