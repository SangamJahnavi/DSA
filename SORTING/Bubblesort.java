// package DSA.SORTING;

import java.util.*;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 1, 5, 0 };
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    // swap(arr[j], arr[j - 1]);
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
