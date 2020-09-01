package tictactoe;

import java.util.Random;

public class AIEasy {

    public void AiMoveEasy(GameMatrix matrix) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int xCoordinate;
        int yCoordinate;

        while (true) {
            xCoordinate = random.nextInt(3 - 1 + 1) + 1; // Coordinates range <1-3>
            yCoordinate = random.nextInt(3 - 1 + 1) + 1;
            if (matrix.isFieldOfMatrixFree(xCoordinate, yCoordinate)) {
                matrix.setFieldOfMatrix(xCoordinate, yCoordinate, Symbol.O);
                break; // break while loop
            }
        }
    }
}
