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
