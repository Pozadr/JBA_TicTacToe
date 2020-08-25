package tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    private final int rowQuantity = 3;
    private final int fieldsQuantity = 3;
    private final char[][] gameMatrix = new char[rowQuantity][fieldsQuantity];

    public void gameInitialization() {
        // game init validation
        while(true) {
            System.out.print("Enter cells: ");
            String inputFromUser = getStringInputFromUser();
            if (inputFromUser.length() == 9) {
                fillInitMatrix(inputFromUser);
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
        printMatrix();
    }

    public void runGame() {
        int xCoordinate;
        int yCoordinate;

        while (true) {
            //read coordinates
            System.out.print("Enter the coordinates: ");
            String input = getStringInputFromUser();
            // input String should have only 2 numbers (Integers); first(1-3), second(1-3)
            if (input.length() == 2) {
                try {
                    xCoordinate = Integer.parseInt(input.substring(0, 1)); // first sign from input to xCoordinate
                    yCoordinate = Integer.parseInt(input.substring(1, 2)); // second sign from input to yCoordinate
                    // check if coordinates are not 0. Should be range <1-3>.
                    if (xCoordinate >= 1 && xCoordinate <= 3 && yCoordinate >= 1 && yCoordinate <= 3 ) {
                        // if cell is empty
                        if (gameMatrix[3 - yCoordinate][xCoordinate - 1] == ' ') {
                            /*
                            check:
                            Since the game always starts with X, if the number of X's and O's on the field is the same,
                            the user should make a move with X, and if X's is one more than O's,
                            then the user should make a move with O.
                            */
                            if (checkXMoreThanO()) {
                                gameMatrix[3 - yCoordinate][xCoordinate - 1] = 'O';
                            } else {
                                gameMatrix[3 - yCoordinate][xCoordinate - 1] = 'X';
                            }
                            printMatrix();
                            checkWhoWonTheGame();

                            break; // break while loop
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        /* Suppose the bottom left cell has the coordinates (1, 1)
                        and the top right cell has the coordinates (3, 3) like in this table:
                        (1, 3) (2, 3) (3, 3)
                        (1, 2) (2, 2) (3, 2)
                        (1, 1) (2, 1) (3, 1) */
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("You should enter numbers!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }
    private boolean checkXMoreThanO() {
        int xCounter = 0;
        int oCounter = 0;
        for (int i = 0; i < gameMatrix.length; i++) {
            for (int j = 0; j < gameMatrix.length; j++) {
                if (gameMatrix[i][j] == 'X') {
                    xCounter++;
                } else if (gameMatrix[i][j] == 'O') {
                    oCounter++;
                }
            }
        }
        return xCounter >= oCounter;
    }
    private void checkWhoWonTheGame() {
        System.out.println("Game not finished");
    }
    private String getStringInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().replaceAll(" ","");  // replaceAll to cut all spaces
    }

    private void fillInitMatrix (String userGameLayoutInput) {
        // userGameLayoutInput --> gameMatrix. String input used to fill two-dimensional array.
        int charCounter = 0;
        for (int i = 0; i < gameMatrix.length; i++) {
            for (int j = 0; j < gameMatrix.length; j++) {
                if (userGameLayoutInput.charAt(charCounter) == '_') {
                    gameMatrix[i][j] = ' ';
                } else {
                    gameMatrix[i][j] = userGameLayoutInput.charAt(charCounter);
                }
                charCounter++;
            }
        }
    }

    private void printMatrix() {
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
    }
}
