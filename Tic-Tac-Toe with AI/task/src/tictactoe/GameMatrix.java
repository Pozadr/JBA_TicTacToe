package tictactoe;

import java.util.ArrayList;

public class GameMatrix {
    private final Symbol[] gameMatrix;

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


    public Symbol[] getGameMatrix() {
        return gameMatrix;
    }

    protected boolean isFieldOfMatrixFree(int field) {
        return gameMatrix[field] == Symbol.EMPTY;
    }

    protected void setFieldOfMatrix(int field, Symbol symbol) {
        gameMatrix[field]= symbol;
    }


    /**
     * Function check are 3 symbols in a row/column/diagonal.
     * @param symbol - symbol to check on matrix.
     * @return - winner / no winner
     */
    public boolean isWinner( Symbol symbol) {
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


    /**
     * Function check is it possible to win with next move.
     * May be used to check player move or to block next opponent move.
     *
     * @param symbol - which symbol should be search in matrix.
     * @return - result [0] = two in row -> 1; not -> 0; result [1] = field
     *
     */
    protected int[] checkFieldToWinNextMove(Symbol symbol) {
        int[] result = new int[2]; // [0, 1]

        // check rows
        int symbolCounter = 0;
        for (int i = 0; i < gameMatrix.length; i++) {
            if (i == 3 || i == 6) {
                symbolCounter = 0; // for each row reset counter
            }
            if (gameMatrix[i] == symbol) {
                symbolCounter++;
                if (symbolCounter == 2) {
                    // check which field is EMPTY
                    int n = 0;
                    if (i == 0 || i == 1 || i == 2) {
                        n = 0;
                    } else if (i == 3 || i == 4 || i == 5) {
                        n = 3;
                    } else if (i == 6 || i == 7 || i == 8) {
                        n = 6;
                    }
                    for (int k = n; k < n + 3; k++) {
                        if (isFieldOfMatrixFree(k)) {
                            result[0] = 1;
                            result[1] = k;
                            return result;
                        }
                    }
                }
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            symbolCounter = 0; // for each column reset counter
            for (int j = i; j <= i + 6; j = j + 3) {
                if (gameMatrix[j] == symbol) {
                    symbolCounter++;
                    if (symbolCounter == 2) {
                        // check which field is EMPTY
                        for (int k = i; k <= i + 6; k = k + 3) {
                            if (isFieldOfMatrixFree(k)) {
                                result[0] = 1;
                                result[1] = k;
                                return result;
                            }
                        }
                    }
                }
            }
        }

        // check diagonals
        if (       gameMatrix[0] == symbol && gameMatrix[4] == symbol
                || gameMatrix[0] == symbol && gameMatrix[8] == symbol
                || gameMatrix[4] == symbol && gameMatrix[8] == symbol)
        {
            if (gameMatrix[0] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 0;
                return result;
            } else if (gameMatrix[4] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 4;
                return result;
            } else if (gameMatrix[8] == Symbol.EMPTY){
                result[0] = 1;
                result[1] = 8;
                return result;
            }
        }
        else if (    gameMatrix[6] == symbol && gameMatrix[4] == symbol
                || gameMatrix[6] == symbol && gameMatrix[2] == symbol
                || gameMatrix[4] == symbol && gameMatrix[2] == symbol)
        {
            if (gameMatrix[6] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 6;
                return result;
            } else if (gameMatrix[4] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 4;
                return result;
            } else if (gameMatrix[2] == Symbol.EMPTY) {
                result[0] = 1;
                result[1] = 2;
                return result;
            }
        }
        // there is no 2 symbols in a row/column/diagonal or possible move is blocked by opponent
        return result; // {0, 0}
    }

    protected ArrayList<Integer> checkEmptyFields(Symbol[] gameMatrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < gameMatrix.length; i++) {
            if (isFieldOfMatrixFree(i)) {
                result.add(i);
            }
        }
        return result;
    }

    protected void printMatrix() {
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
