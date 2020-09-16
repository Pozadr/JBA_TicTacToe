package tictactoe;

public class GameMatrix {
    public final Symbol[] gameMatrix;

    /**
     * Game Matrix -  0, 1, 2,
     *                3, 4, 5,
     *                6, 7, 8
     * There is 9 possible move in Tic-Tac-Toe game.
     */
    public GameMatrix() {
        gameMatrix = new Symbol[] { Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY,
                                    Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY,
                                    Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY};
    }

    public boolean isFieldOfMatrixFree(int field) {
        return gameMatrix[field] == Symbol.EMPTY;
    }

    public void setFieldOfMatrix(int field, Symbol symbol) {
        gameMatrix[field]= symbol;
    }

    public boolean isWinner(Symbol symbol) {
        //Check if there are some 'O' or 'X' in line: 00 01 02 | 10 11 12 | 20 21 22 | 00 10 20 | 01 11 21 | 02 12 22
        // or to the cross: 00 11 22 | 02 11 20.
        return     gameMatrix[0] == symbol && gameMatrix[1] == symbol && gameMatrix[2] == symbol // 1st row
                || gameMatrix[3] == symbol && gameMatrix[4] == symbol && gameMatrix[5] == symbol // 2nd row
                || gameMatrix[6] == symbol && gameMatrix[7] == symbol && gameMatrix[8] == symbol // 3rd row
                || gameMatrix[0] == symbol && gameMatrix[3] == symbol && gameMatrix[6] == symbol // 1st column
                || gameMatrix[1] == symbol && gameMatrix[4] == symbol && gameMatrix[7] == symbol // 2nd column
                || gameMatrix[2] == symbol && gameMatrix[5] == symbol && gameMatrix[8] == symbol // 3rd column
                || gameMatrix[0] == symbol && gameMatrix[4] == symbol && gameMatrix[8] == symbol // diagonal
                || gameMatrix[6] == symbol && gameMatrix[4] == symbol && gameMatrix[2] == symbol; // diagonal
    }

    public boolean isDraw () {
        return gameMatrix[0] != Symbol.EMPTY && gameMatrix[1] != Symbol.EMPTY && gameMatrix[2] != Symbol.EMPTY
                && gameMatrix[3] != Symbol.EMPTY && gameMatrix[4] != Symbol.EMPTY && gameMatrix[5] != Symbol.EMPTY
                && gameMatrix[6] != Symbol.EMPTY && gameMatrix[7] != Symbol.EMPTY && gameMatrix[8] != Symbol.EMPTY;
    }


    public int[] checkTwoInRow(Symbol symbol) {
        int xCoordinate;
        int yCoordinate;
        int[] result = new int[3];
        /*
        result [0] = two in row -> 1; not -> 0
        result [1] = xCoordinate
        result [2] = yCoordinate
         */

        // check rows
        /*
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

         */
        return result;


    }

    public void printMatrix() {
        for (int i = 0; i < gameMatrix.length; i++) {
            if (i == 0) {
                System.out.println("---------");
            }
            if (i == 0 || i == 3 || i == 6) {
                System.out.print("| ");
            }
            System.out.print(gameMatrix[i].getSymbol() + " ");
            if (i == 2 || i == 5 || i == 8) {
                System.out.print("|");
                System.out.println();
            }
            if (i == gameMatrix.length - 1) {
                System.out.println("---------");
            }
        }
    }

}
