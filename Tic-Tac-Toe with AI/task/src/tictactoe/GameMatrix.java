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

    public boolean checkWhoWonTheGame() {
        //Check if there are some 'O' or 'X' in line: 00 01 02 | 10 11 12 | 20 21 22 | 00 10 20 | 01 11 21 | 02 12 22
        // or to the cross: 00 11 22 | 02 11 20.
        if (       gameMatrix[0][0] == Symbol.X && gameMatrix[0][1] == Symbol.X && gameMatrix[0][2] == Symbol.X
                || gameMatrix[1][0] == Symbol.X && gameMatrix[1][1] == Symbol.X && gameMatrix[1][2] == Symbol.X
                || gameMatrix[2][0] == Symbol.X && gameMatrix[2][1] == Symbol.X && gameMatrix[2][2] == Symbol.X
                || gameMatrix[0][0] == Symbol.X && gameMatrix[1][0] == Symbol.X && gameMatrix[2][0] == Symbol.X
                || gameMatrix[0][1] == Symbol.X && gameMatrix[1][1] == Symbol.X && gameMatrix[2][1] == Symbol.X
                || gameMatrix[0][2] == Symbol.X && gameMatrix[1][2] == Symbol.X && gameMatrix[2][2] == Symbol.X
                || gameMatrix[0][0] == Symbol.X && gameMatrix[1][1] == Symbol.X && gameMatrix[2][2] == Symbol.X
                || gameMatrix[0][2] == Symbol.X && gameMatrix[1][1] == Symbol.X && gameMatrix[2][0] == Symbol.X) {
            System.out.println("X wins");
            return true;
        } else if (gameMatrix[0][0] == Symbol.O && gameMatrix[0][1] == Symbol.O && gameMatrix[0][2] == Symbol.O
                || gameMatrix[1][0] == Symbol.O && gameMatrix[1][1] == Symbol.O && gameMatrix[1][2] == Symbol.O
                || gameMatrix[2][0] == Symbol.O && gameMatrix[2][1] == Symbol.O && gameMatrix[2][2] == Symbol.O
                || gameMatrix[0][0] == Symbol.O && gameMatrix[1][0] == Symbol.O && gameMatrix[2][0] == Symbol.O
                || gameMatrix[0][1] == Symbol.O && gameMatrix[1][1] == Symbol.O && gameMatrix[2][1] == Symbol.O
                || gameMatrix[0][2] == Symbol.O && gameMatrix[1][2] == Symbol.O && gameMatrix[2][2] == Symbol.O
                || gameMatrix[0][0] == Symbol.O && gameMatrix[1][1] == Symbol.O && gameMatrix[2][2] == Symbol.O
                || gameMatrix[0][2] == Symbol.O && gameMatrix[1][1] == Symbol.O && gameMatrix[2][0] == Symbol.O) {
            System.out.println("O wins");
            return true;
        } else if (gameMatrix[0][0] != Symbol.EMPTY && gameMatrix[0][1] != Symbol.EMPTY && gameMatrix[0][2] != Symbol.EMPTY
                && gameMatrix[1][0] != Symbol.EMPTY && gameMatrix[1][1] != Symbol.EMPTY && gameMatrix[1][2] != Symbol.EMPTY
                && gameMatrix[2][0] != Symbol.EMPTY && gameMatrix[2][1] != Symbol.EMPTY && gameMatrix[2][2] != Symbol.EMPTY) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public void fillInitMatrix (String userGameLayoutInput) {
        // userGameLayoutInput --> gameMatrix. String input used to fill two-dimensional array.
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
