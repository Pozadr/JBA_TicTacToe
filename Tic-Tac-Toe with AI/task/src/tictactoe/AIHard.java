package tictactoe;

import java.util.ArrayList;

public class AIHard extends Player {
    private final Symbol opponentSymbol = getOpponentSymbol(this.symbol);
    private Point bestMove;

    public AIHard (Symbol symbol) {
        super(symbol);
    }

    @Override
    public void move(GameMatrix matrix) {
        minimax(matrix, 0, this.symbol);
        matrix.gameMatrix[bestMove.x][bestMove.y] = this.symbol;

    }

    /**
     * Minimax function which is simulating the game. It simulates all possibilities until game finish.
     * Then check best possible movement for HardAI player.
     * There is no possibility to win with minimax algorithm. Can be only the draw or lose.
     *
     * Optimized by breaking loops during searching for best score.
     * @param matrix - current gameMatrix state.
     * @param depth - depth of minimax algorithm recursion.
     * @param player - variable to check which player turn is.
     * @return
     */
    private int minimax (GameMatrix matrix, int depth, Symbol player) {
        if (matrix.isWinner(opponentSymbol)) {
            return -10;
        }
        else if (matrix.isWinner(this.symbol)) {
            return 10;
        }
        ArrayList<Point> availMoves = matrix.getAvailableMoves();
        if (availMoves.isEmpty()) {
            return 0;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < availMoves.size(); i++) {
            Point point = availMoves.get(i);
            if (player == this.symbol) {
                matrix.gameMatrix[point.x][point.y] = this.symbol;
                int currentScore = minimax(matrix,depth + 1, opponentSymbol);
                max = Math.max(currentScore, max);
                if (depth == 0) System.out.println("Score for position "+(i+1)+" = "+currentScore);
                if (currentScore >= 0) {
                    if (depth == 0) {
                        bestMove = point;
                    }
                }
                if (currentScore == 10) {
                    matrix.gameMatrix[point.x][point.y] = Symbol.EMPTY;
                    break;
                }
                if (i == availMoves.size() - 1 && max < 0) {
                    if (depth == 0) {
                        bestMove = point;
                    }
                }
            } else if (player == opponentSymbol) {
                matrix.gameMatrix[point.x][point.y] = opponentSymbol;
                int currentScore = minimax(matrix, depth + 1, this.symbol);
                min = Math.min(currentScore, min);
                if (min == -10) {
                    matrix.gameMatrix[point.x][point.y] = Symbol.EMPTY;
                    break;
                }
            }
            matrix.gameMatrix[point.x][point.y] = Symbol.EMPTY;
        }
        return player == this.symbol ? max:min;

    }

    private Symbol getOpponentSymbol(Symbol mySymbol) {
        if (mySymbol == Symbol.X) {
            return Symbol.O;
        } else {
            return Symbol.X;
        }
    }
}
