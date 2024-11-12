import java.util.*;

public class Sublistdup {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        System.out.println(fun(arr));
    }

    public static List<List<Integer>> fun(int[] arr) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = l.size() - 1;
            int n = l.size();
            for (int j = start; j < n; j++) {
                List<Integer> l1 = new ArrayList<>();
                l1.addAll(l.get(j));
                l1.add(arr[i]);
                l.add(l1);
            }

        }
        return l;
    }
}
