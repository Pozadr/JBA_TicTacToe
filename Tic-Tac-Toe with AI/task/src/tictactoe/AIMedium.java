package tictactoe;

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
        // declaration of an array of results to interpret
        int[] checkingResult = matrix.checkFieldToWinNextMove(symbol);
        // check if you can win
        if(checkingResult[0] == 1) {
            matrix.gameMatrix[checkingResult[1]] = symbol;
        } else {
            // check if opponent can win
            if (this.symbol == Symbol.O) {
                checkingResult = matrix.checkFieldToWinNextMove(Symbol.X);
            } else {
                checkingResult = matrix.checkFieldToWinNextMove(Symbol.O);
            }
            if(checkingResult[0] == 1) {
                matrix.gameMatrix[checkingResult[1]] = symbol;
            } else {
                // make a random move
                while (true) {
                    int field;
                    Random random = new Random();
                    field = random.nextInt( 9); // Coordinates range <0-8>
                    if (matrix.isFieldOfMatrixFree(field)) {
                        matrix.setFieldOfMatrix(field, symbol);
                        break; // break while loop
                    }
                }
            }
        }


    }
}
