import java.util.*;

public class Sublist {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(fun(arr));
    }

    public static List<List<Integer>> fun(int[] arr) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        for (int i : arr) {
            int n = l.size();
            for (int j = 0; j < n; j++) {
                List<Integer> l1 = new ArrayList<>();
                l1.addAll(l.get(j));
                l1.add(i);
                l.add(l1);
            }

        }
        return l;
    }
}
