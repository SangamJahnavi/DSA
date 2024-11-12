// * 
// * *
// * * *
// * * * *

public class Pattern2 {
    public static void main(String[] args) {
        fun(4, 0);
    }

    public static void fun(int r, int c) {
        if (r + 1 == c) {
            return;
        }
        int k = 0;
        while (k != c) {
            System.out.print("* ");
            k += 1;
        }
        System.out.println();
        fun(r, c + 1);
    }
}
