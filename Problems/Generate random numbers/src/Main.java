import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long sum = 0;

        Random random = new Random(a + b);

        while (n > 0) {
            sum += random.nextInt(b - a + 1) + a;
            n--;
        }
        System.out.println(sum);
    }
}