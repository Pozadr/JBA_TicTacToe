package tictactoe;

import java.util.Random;

public class AIMedium extends Player {
    Symbol symbol;

    public AIMedium (Symbol symbol) {
        this.symbol = symbol;
    }

    public void move(GameMatrix matrix) {
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        int xCoordinate;
        int yCoordinate;

        // declaration of an array of results to interpret
        int[] checkingResult = matrix.checkTwoInRow(symbol);
        // check if you can win
        if(checkingResult[0] == 1) {
            matrix.gameMatrix[checkingResult[1]][checkingResult[2]] = symbol;
        } else {
            // check if opponent can win
            if (this.symbol == Symbol.O) {
                checkingResult = matrix.checkTwoInRow(Symbol.X);
            } else {
                checkingResult = matrix.checkTwoInRow(Symbol.O);
            }
            if(checkingResult[0] == 1) {
                matrix.gameMatrix[checkingResult[1]][checkingResult[2]] = symbol;
            } else {
                // make a random move
                while (true) {
                    xCoordinate = random.nextInt(3 - 1 + 1) + 1; // Coordinates range <1-3>
                    yCoordinate = random.nextInt(3 - 1 + 1) + 1;
                    if (matrix.isFieldOfMatrixFree(xCoordinate, yCoordinate)) {
                        matrix.setFieldOfMatrix(xCoordinate, yCoordinate, symbol);
                        break; // break while loop
                    }
                }
            }
        }
    }
}
