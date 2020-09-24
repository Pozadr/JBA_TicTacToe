package tictactoe.matrix;

import java.util.ArrayList;

public class GameMatrix {
    public final Symbol[][] gameMatrix;

    /**
     * Game Matrix -  AI board fields numbering:
     *                (0 0) (0 1) (0 2)
     *                (1 0) (1 1) (1 2)
     *                (2 0) (2 1) (2 2)
     *
     *                User board fields numbering required by task:
     *                (1 3) (2 3) (3 3)
     *                (1 2) (2 2) (3 2)
     *                (1 1) (2 1) (3 1)
     */
    public GameMatrix() {
        gameMatrix = new Symbol[][]{
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY}
        };
    }

    public boolean isFieldOfRotatedMatrixFree(int x, int y) {
        return gameMatrix[3 - y][x - 1] == Symbol.EMPTY;
    }

    public boolean isFieldOfMatrixFree(int x, int y) {
        return gameMatrix[x][y] == Symbol.EMPTY;
    }

    public void setFieldOfRotatedMatrix(int x, int y, Symbol symbol) {
        gameMatrix[3 - y][x - 1] = symbol;
    }

    public boolean isWinner(Symbol symbol) {
        if ((gameMatrix[0][0] == gameMatrix[1][1] && gameMatrix[0][0] == gameMatrix[2][2] && gameMatrix[0][0] == symbol) || (gameMatrix[0][2] == gameMatrix[1][1] && gameMatrix[0][2] == gameMatrix[2][0] && gameMatrix[0][2] == symbol)) {
            //System.out.println("X Diagonal Win");
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((gameMatrix[i][0] == gameMatrix[i][1] && gameMatrix[i][0] == gameMatrix[i][2] && gameMatrix[i][0] == symbol)
                    || (gameMatrix[0][i] == gameMatrix[1][i] && gameMatrix[0][i] == gameMatrix[2][i] && gameMatrix[0][i] == symbol))) {
                // System.out.println("X Row or Column win");
                return true;
            }
        }
        return false;
    }

    public boolean isDraw () {
        for (Symbol[] matrix : gameMatrix) { // take whole row
            for (int j = 0; j < gameMatrix.length; j++) { // increment each field of row
                if (matrix[j] == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    public ArrayList<Point> getAvailableMoves() {
        ArrayList<Point> availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (gameMatrix[i][j] == Symbol.EMPTY) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }

    /**
     * Function check is it possible to win with next move.
     * May be used to check player move or to block next opponent move.
     *
     * @param symbol - which symbol should be search in matrix.
     * @return - result [0] = two in row -> 1; not -> 0; result [1] = x; result [2] = y
     *
     */
    public int[] checkFieldToWinNextMove(Symbol symbol) {
        int xCoordinate;
        int yCoordinate;
        int[] result = new int[3];
        /*
        result [0] = two in row -> 1; not -> 0
        result [1] = xCoordinate
        result [2] = yCoordinate
         */

        // check rows
        for (int i = 0; i < gameMatrix.length; i++) {
            int symbolCounter = 0;
            for (int j = 0; j < gameMatrix.length; j++) {
                if (gameMatrix[i][j] == symbol) {
                    symbolCounter++;
                    if (symbolCounter == 2) {
                        xCoordinate = i;
                        for (int k = 0; k < gameMatrix.length; k++) {
                            if (gameMatrix[xCoordinate][k] == Symbol.EMPTY) {
                                yCoordinate = k;
                                result[0] = 1;
                                result[1] = xCoordinate;
                                result[2] = yCoordinate;
                                return result;
                            }
                        }
                    }
                }
            }
        }
        // check columns
        for (int i = 0; i < gameMatrix.length; i++) {
            int symbolCounter = 0;
            for (int j = 0; j < gameMatrix.length; j++) {
                if (gameMatrix[j][i] == symbol) {
                    symbolCounter++;
                    if (symbolCounter == 2) {
                        yCoordinate = i;
                        for (int k = 0; k < gameMatrix.length; k++) {
                            if (gameMatrix[k][yCoordinate] == Symbol.EMPTY) {
                                xCoordinate = k;
                                result[0] = 1;
                                result[1] = xCoordinate;
                                result[2] = yCoordinate;
                                return result;
                            }
                        }
                    }
                }
            }
        }
        // check diagonals
        if (       gameMatrix[0][0] == symbol && gameMatrix[1][1] == symbol
                || gameMatrix[0][0] == symbol && gameMatrix[2][2] == symbol
                || gameMatrix[1][1] == symbol && gameMatrix[2][2] == symbol)
        {
            if (gameMatrix[0][0] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 0;
                result[2] = 0;
                return result;
            } else if (gameMatrix[1][1] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 1;
                result[2] = 1;
                return result;
            } else if (gameMatrix[2][2] == Symbol.EMPTY){
                result[0] = 1;
                result[1] = 2;
                result[2] = 2;
                return result;
            }
        }
        else if (    gameMatrix[0][2] == symbol && gameMatrix[1][1] == symbol
                || gameMatrix[0][2] == symbol && gameMatrix[2][0] == symbol
                || gameMatrix[1][1] == symbol && gameMatrix[2][0] == symbol)
        {
            if (gameMatrix[0][2] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 0;
                result[2] = 2;
                return result;
            } else if (gameMatrix[1][1] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 1;
                result[2] = 1;
                return result;
            } else if (gameMatrix[2][0] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 2;
                result[2] = 0;
                return result;
            }
        }
        result[0] = 0; // there is no 2 symbols in a row/column/diagonal or possible move is blocked by opponent
        return result;
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
                System.out.print(gameMatrix[i][j].getSymbol() + " ");
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
