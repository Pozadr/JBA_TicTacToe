import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] arr = new String[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == n / 2 || j == n / 2 || i == j || (n - i - 1) == j) {
                    arr[i][j] = "* ";
                } else {
                    arr[i][j] = ". ";
                }
            }
        }
        for (String[] strings : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }
}