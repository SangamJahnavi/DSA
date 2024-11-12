import java.util.*;

public class Selectionsort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        System.out.println(Arrays.toString(fun(arr, 4, 0, 0)));
    }

    public static int[] fun(int[] arr, int r, int c, int max) {
        if (r == 0) {
            return arr;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                return fun(arr, r, c + 1, c);
            } else {
                return fun(arr, r, c + 1, max);
            }
        } else {
            swap(arr, max, r - 1);
            return fun(arr, r - 1, 0, 0);
        }
        // return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
