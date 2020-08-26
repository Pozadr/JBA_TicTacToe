package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    private char[][] gameMatrix = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };


    public void AiMoveEasy() {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int xCoordinate;
        int yCoordinate;

        while (true) {
            xCoordinate = random.nextInt(3 - 1 + 1) + 1; // Coordinates range <1-3>
            yCoordinate = random.nextInt(3 - 1 + 1) + 1;
            if (gameMatrix[3 - yCoordinate][xCoordinate - 1] == ' ') {
                gameMatrix[3 - yCoordinate][xCoordinate - 1] = 'O';
                break; // break while loop
            }
        }

    }
    public void userMove() {
        Scanner scanner = new Scanner(System.in);

        int xCoordinate;
        int yCoordinate;

        while (true) {
            //read coordinates
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine().replaceAll(" ","");  // replaceAll to cut all spaces
            // input String should have only 2 numbers (Integers); first(1-3), second(1-3)
            if (input.length() == 2) {
                try {
                    xCoordinate = Integer.parseInt(input.substring(0, 1)); // first sign from input to xCoordinate
                    yCoordinate = Integer.parseInt(input.substring(1, 2)); // second sign from input to yCoordinate
                    // check if coordinates are not 0. Should be range <1-3>.
                    if (xCoordinate >= 1 && xCoordinate <= 3 && yCoordinate >= 1 && yCoordinate <= 3 ) {
                        // if cell is empty
                        if (gameMatrix[3 - yCoordinate][xCoordinate - 1] == ' ') {
                            gameMatrix[3 - yCoordinate][xCoordinate - 1] = 'X';
                            break; // break while loop
                        } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("You should enter numbers!");
                }
            } else {
                System.out.println("Wrong input! Try again!");
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
        return xCounter > oCounter;
    }

    public boolean checkWhoWonTheGame() {
        //Check if there are some 'O' or 'X' in line: 00 01 02 | 10 11 12 | 20 21 22 | 00 10 20 | 01 11 21 | 02 12 22
        // or to the cross: 00 11 22 | 02 11 20.
        if (       gameMatrix[0][0] == 'X' && gameMatrix[0][1] == 'X' && gameMatrix[0][2] == 'X'
                || gameMatrix[1][0] == 'X' && gameMatrix[1][1] == 'X' && gameMatrix[1][2] == 'X'
                || gameMatrix[2][0] == 'X' && gameMatrix[2][1] == 'X' && gameMatrix[2][2] == 'X'
                || gameMatrix[0][0] == 'X' && gameMatrix[1][0] == 'X' && gameMatrix[2][0] == 'X'
                || gameMatrix[0][1] == 'X' && gameMatrix[1][1] == 'X' && gameMatrix[2][1] == 'X'
                || gameMatrix[0][2] == 'X' && gameMatrix[1][2] == 'X' && gameMatrix[2][2] == 'X'
                || gameMatrix[0][0] == 'X' && gameMatrix[1][1] == 'X' && gameMatrix[2][2] == 'X'
                || gameMatrix[0][2] == 'X' && gameMatrix[1][1] == 'X' && gameMatrix[2][0] == 'X') {
            System.out.println("X wins");
            return true;
        } else if (gameMatrix[0][0] == 'O' && gameMatrix[0][1] == 'O' && gameMatrix[0][2] == 'O'
                || gameMatrix[1][0] == 'O' && gameMatrix[1][1] == 'O' && gameMatrix[1][2] == 'O'
                || gameMatrix[2][0] == 'O' && gameMatrix[2][1] == 'O' && gameMatrix[2][2] == 'O'
                || gameMatrix[0][0] == 'O' && gameMatrix[1][0] == 'O' && gameMatrix[2][0] == 'O'
                || gameMatrix[0][1] == 'O' && gameMatrix[1][1] == 'O' && gameMatrix[2][1] == 'O'
                || gameMatrix[0][2] == 'O' && gameMatrix[1][2] == 'O' && gameMatrix[2][2] == 'O'
                || gameMatrix[0][0] == 'O' && gameMatrix[1][1] == 'O' && gameMatrix[2][2] == 'O'
                || gameMatrix[0][2] == 'O' && gameMatrix[1][1] == 'O' && gameMatrix[2][0] == 'O') {
            System.out.println("O wins");
            return true;
        } else if (gameMatrix[0][0] != ' ' && gameMatrix[0][1] != ' ' && gameMatrix[0][2] != ' '
                && gameMatrix[1][0] != ' ' && gameMatrix[1][1] != ' ' && gameMatrix[1][2] != ' '
                && gameMatrix[2][0] != ' ' && gameMatrix[2][1] != ' ' && gameMatrix[2][2] != ' ') {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public void fillInitMatrix (String userGameLayoutInput) {
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

    public void printMatrix() {
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
