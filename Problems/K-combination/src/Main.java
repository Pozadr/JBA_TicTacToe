import java.util.Scanner;

public class Main {

    public static int comb(int n, int k) {
        // write your code here
        System.out.println("n = " + n + " " + "k = " + k);
        if (k > n) {
            return 0;
        } else if (k == 0) {
            return 1;
        } else {
            return comb(n - 1, k) + comb(n - 1, k -1);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        System.out.println(comb(n, k));
    }
}