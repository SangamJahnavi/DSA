public class Subseqascii {
    public static void main(String[] args) {
        fun("", "abc");
    }

    public static void fun(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        fun(p + up.charAt(0), up.substring(1));
        fun(p + (up.charAt(0) + 0), up.substring(1));
        fun(p, up.substring(1));
    }
}
