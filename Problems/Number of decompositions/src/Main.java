import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        decomposition(n, 0);

        // put your code here
    }

    public static int[] decomposition (int n, int sum) {
        while ((n - sum) < 0) {
            if (sum == 0) {
                sum = 1;
            }
            System.out.print(sum);
            n--;
        }
        if (n == 1) {
            return 0;
        } else {
            decomposition(n - 1, sum + 1);
        }
    }
}