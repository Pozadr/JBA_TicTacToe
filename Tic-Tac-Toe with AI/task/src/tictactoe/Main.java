package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int rowQuantity = 3;
        final int fieldsQuantity = 3;
        char [][] gameMatrix = new char[rowQuantity][fieldsQuantity];

        System.out.print("Enter cells: ");
        String userGameLayoutInput = scanner.next().trim();  // trim to avoid spaces after input

        // userGameLayoutInput --> gameMatrix
        int charCounter = 0;
        for (int i = 0; i < gameMatrix.length; i++) {
            for (int j = 0; j < gameMatrix.length; j++) {
                if (userGameLayoutInput.charAt(charCounter) == '_'){
                    gameMatrix[i][j] = ' ';
                } else {
                    gameMatrix[i][j] = userGameLayoutInput.charAt(charCounter);
                }
                charCounter++;
            }
        }

        // print gameMatrix
        for (int i = 0; i < gameMatrix.length; i++) {
            if (i == 0) {
                System.out.println("---------");
            }
            for (int j = 0; j < gameMatrix.length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(gameMatrix[i][j] + " ");
                if (j == gameMatrix.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i == gameMatrix.length - 1) {
                System.out.println("---------");
            }
        }
        boolean flag = true;
        int xCoordinate = 0;
        int yCoordinate = 0;
        while(flag) {
            System.out.print("Enter the coordinates: ");
            scanner.next();
            if (scanner.hasNextInt()) {  // x coordinate
                xCoordinate = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    yCoordinate = scanner.nextInt();
                    flag = false;
                } else {
                    System.out.println("You should enter numbers!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        System.out.println((xCoordinate) + (yCoordinate));

    }
}
