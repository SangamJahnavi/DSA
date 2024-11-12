// bubble sort using recursion

import java.util.*;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        // System.out.println(Arrays.toString(bs(arr, 4, 4)));
        System.out.println(Arrays.toString(bs1(arr, 4, 4)));
    }

    public static int[] bs(int[] arr, int r, int c) {
        if (c == 0) {
            return arr;
        }
        boolean swapped = false;
        for (int i = 0; i < c - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swapped = true;
                swap(arr, i, i + 1);
            }
        }
        if (swapped = false) {
            return arr;
        }
        bs(arr, r, c - 1);
        return arr;

    }

    public static int[] bs1(int[] arr, int r, int c) {
        if (r == 0) {
            return arr;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                swap(arr, c, c + 1);
            }
            return bs1(arr, r, c + 1);
        } else {
            return bs1(arr, r - 1, 0);
        }
        // return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
