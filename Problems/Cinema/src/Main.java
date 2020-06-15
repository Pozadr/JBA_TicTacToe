import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int seat = scanner.nextInt();
        String[][] inputArr = new String[row][seat];

        // read input array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                inputArr[i][j] = scanner.next();
            }
        }
        int tickets = scanner.nextInt();
        /*
        // print input
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                System.out.print(inputArr[i][j] + " ");
            }
            System.out.println();
        }
         */

        //check seats
        for (int i = 0; i < row; i++) {
            int tmpTik = tickets;
            for (int j = 0; j < seat; j++) {
                if (inputArr[i][j].equals("0")) {
                    tmpTik--;
                    if (tmpTik == 0) {
                        System.out.println(i + 1);
                        break;
                    }
                } else {
                    tmpTik = tickets;
                }
            }
            if (tmpTik == 0) {
                break;
            } else if (i == row - 1) {
                System.out.println(0);
            }
        }
    }
}