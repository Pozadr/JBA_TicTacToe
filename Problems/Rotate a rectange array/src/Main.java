import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String[][] inputArr = new String[m][n];

        // read input array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                inputArr[i][j] = scanner.next();
            }
        }

        // rotate and print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(inputArr[m - 1 - j][i] + " ");
            }
            System.out.println();
        }
    }
}