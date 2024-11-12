import java.util.ArrayList;
import java.util.List;

// this wont work in leetcode as the number arrangement is totally different C
public class Lettercomb {
    class Solution {
        // public static ArrayList<String> l=new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            ArrayList<String> l = new ArrayList<>();
            fun("", digits, l);
            return l;
        }

        public static ArrayList<String> fun(String p, String up, ArrayList<String> l) {
            if (up.isEmpty()) {
                l.add(p);
                return l;
            }

            int digit = up.charAt(0) - '0';
            int r = (digit - 1) * 3;
            int c = digit * 3;
            for (int i = r; i < c; i++) {
                char ch = (char) ('a' + i);
                fun(p + ch, up.substring(1), l);
            }
            return l;
        }
    }
}
