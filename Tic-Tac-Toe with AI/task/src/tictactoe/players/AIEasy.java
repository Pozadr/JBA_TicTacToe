package tictactoe.players;

import tictactoe.matrix.GameMatrix;
import tictactoe.matrix.Symbol;

import java.util.Random;

public class AIEasy extends Player {

    public AIEasy (Symbol symbol) {
        super(symbol);
    }

    /**
     * Easy level of AI:
     * do a move on random field.
     */
    @Override
    public void move(GameMatrix matrix) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int xCoordinate;
        int yCoordinate;

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
