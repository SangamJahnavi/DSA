import java.util.*;

public class Majorityelement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityelement(arr, 0, n - 1));
    }

    public static int count(int[] arr, int l, int u, int x) {
        int count = 0;
        for (int i = 0; i < u; i++) {
            if (arr[i] == x) {
                count += 1;
            }
        }
        return count;
    }

    public static int majorityelement(int[] arr, int l, int u) {
        if (l == u) {
            return arr[l];
        }
        int mid = l + (u - l) / 2;
        int left = majorityelement(arr, l, mid);
        int right = majorityelement(arr, mid + 1, u);
        if (left == right) {
            return left;
        }
        int lc = count(arr, l, u, left);
        int rc = count(arr, l, u, right);
        if (lc > rc) {
            return left;
        } else {
            return right;
        }
    }
}