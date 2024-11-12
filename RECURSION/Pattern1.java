// ****
// ***
// **
// *
public class Pattern1 {

    public static void main(String[] args) {
        fun(4, 0);
    }

    public static void fun(int r, int c) {
        if (c == r) {
            return;
        }
        int k = c;
        while (k != r) {
            System.out.print("* ");
            k++;
        }
        System.out.println();
        fun(r, c + 1);
    }
}