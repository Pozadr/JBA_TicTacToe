package tictactoe;

public class GameMatrix {
    public final Symbol[][] gameMatrix;

    public GameMatrix() {
        gameMatrix = new Symbol[][]{
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY},
                {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY}
        };
    }

    public boolean isFieldOfMatrixFree(int x, int y) {
        int column = x - 1;
        int row = 3 - y;

        return gameMatrix[row][column] == Symbol.EMPTY;
    }

    public void setFieldOfMatrix(int x, int y, Symbol symbol) {
        int column = x - 1;
        int row = 3 - y;

        gameMatrix[row][column] = symbol;
    }

    public boolean isWinner(Symbol symbol) {
        //Check if there are some 'O' or 'X' in line: 00 01 02 | 10 11 12 | 20 21 22 | 00 10 20 | 01 11 21 | 02 12 22
        // or to the cross: 00 11 22 | 02 11 20.
        return gameMatrix[0][0] == symbol && gameMatrix[0][1] == symbol && gameMatrix[0][2] == symbol
                || gameMatrix[1][0] == symbol && gameMatrix[1][1] == symbol && gameMatrix[1][2] == symbol
                || gameMatrix[2][0] == symbol && gameMatrix[2][1] == symbol && gameMatrix[2][2] == symbol
                || gameMatrix[0][0] == symbol && gameMatrix[1][0] == symbol && gameMatrix[2][0] == symbol
                || gameMatrix[0][1] == symbol && gameMatrix[1][1] == symbol && gameMatrix[2][1] == symbol
                || gameMatrix[0][2] == symbol && gameMatrix[1][2] == symbol && gameMatrix[2][2] == symbol
                || gameMatrix[0][0] == symbol && gameMatrix[1][1] == symbol && gameMatrix[2][2] == symbol
                || gameMatrix[0][2] == symbol && gameMatrix[1][1] == symbol && gameMatrix[2][0] == symbol;
    }

    public boolean isDraw () {
        return gameMatrix[0][0] != Symbol.EMPTY && gameMatrix[0][1] != Symbol.EMPTY && gameMatrix[0][2] != Symbol.EMPTY
                && gameMatrix[1][0] != Symbol.EMPTY && gameMatrix[1][1] != Symbol.EMPTY && gameMatrix[1][2] != Symbol.EMPTY
                && gameMatrix[2][0] != Symbol.EMPTY && gameMatrix[2][1] != Symbol.EMPTY && gameMatrix[2][2] != Symbol.EMPTY;
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

    // ----------------------- OLD STUFF -----------------------
    // Used in stage 1/5 - 2/5
    /*
    public void fillInitMatrix (String userGameLayoutInput) {
        // userGameLayoutInput --> gameMatrix. String input used to fill two-dimensional array. Task 1/5.
        int charCounter = 0;
        for (int i = 0; i < gameMatrix.length; i++) {
            for (int j = 0; j < gameMatrix.length; j++) {
                if (userGameLayoutInput.charAt(charCounter) == '_') {
                    gameMatrix[i][j] = Symbol.EMPTY;
                } else if (userGameLayoutInput.charAt(charCounter) == 'X') {
                    gameMatrix[i][j] = Symbol.X;
                } else if (userGameLayoutInput.charAt(charCounter) == 'O') {
                    gameMatrix[i][j] = Symbol.O;
                }
                charCounter++;
            }
        }
    }

    private boolean checkXMoreThanO() {
        int xCounter = 0;
        int oCounter = 0;
        for (int i = 0; i < gameMatrix.length; i++) {
            for (int j = 0; j < gameMatrix.length; j++) {
                if (gameMatrix[i][j] == Symbol.X) {
                    xCounter++;
                } else if (gameMatrix[i][j] == Symbol.O) {
                    oCounter++;
                }
            }
        }
        return xCounter > oCounter;
    }
     */
}
