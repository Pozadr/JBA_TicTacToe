package tictactoe.players;

import tictactoe.matrix.GameMatrix;
import tictactoe.matrix.Symbol;

import java.util.Random;

public class AIMedium extends Player {

    public AIMedium (Symbol symbol) {
        super(symbol);
    }

    /**
     * Medium level of AI:
     * 1. Check can you win.
     * 2. Check can your opponent win? Block its move.
     * 3. If not 1. and not 2. do a random move.
     */
    @Override
    public void move(GameMatrix matrix) {
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        int xCoordinate;
        int yCoordinate;

        // declaration of an array of results to interpret
        int[] checkingResult = matrix.checkFieldToWinNextMove(symbol);
        // check if you can win
        if(checkingResult[0] == 1) {
            matrix.gameMatrix[checkingResult[1]][checkingResult[2]] = symbol;
        } else {
            // check if opponent can win
            if (this.symbol == Symbol.O) {
                checkingResult = matrix.checkFieldToWinNextMove(Symbol.X);
            } else {
                checkingResult = matrix.checkFieldToWinNextMove(Symbol.O);
            }
            if(checkingResult[0] == 1) {
                matrix.gameMatrix[checkingResult[1]][checkingResult[2]] = symbol;
            } else {
                // make a random move
                while (true) {
                    xCoordinate = random.nextInt(3 - 1 + 1) + 1; // Coordinates range <1-3>
                    yCoordinate = random.nextInt(3 - 1 + 1) + 1;
                    if (matrix.isFieldOfRotatedMatrixFree(xCoordinate, yCoordinate)) {
                        matrix.setFieldOfRotatedMatrix(xCoordinate, yCoordinate, symbol);
                        break; // break while loop
                    }
                }
            }
        }
    }
}
