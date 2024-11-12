import java.util.*;

public class Prag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0;
        for (char i : s.toCharArray()) {
            res ^= i;
            // System.out.println(res);
        }
        // System.out.println(res);
        boolean flag = true;
        if (res == 0) {
            // System.out.println(true);
            return;
        } else {
            for (char i : s.toCharArray()) {
                if (i == (char) res) {
                    flag = false;
                }
            }

        }
        System.out.println(flag);
        System.out.println((char) res);
    }
}