package tictactoe;

import java.util.Random;

public class AIEasy extends Player {

    public AIEasy (Symbol symbol) {
        super(symbol);
    }

    /**
     * Easy level of AI:
     * do a move on random field.
     *
     * @param matrix - current status of game matrix
     */
    @Override
    public void move(GameMatrix matrix) {

        System.out.println("Making move level \"easy\"");
        while (true) {
            Random random = new Random();
            int field;
            field = random.nextInt( 9); // Coordinates range <0-8>
            if (matrix.isFieldOfMatrixFree(field)) {
                matrix.setFieldOfMatrix(field, symbol);
                break; // break while loop
            }
        }
    }
}
