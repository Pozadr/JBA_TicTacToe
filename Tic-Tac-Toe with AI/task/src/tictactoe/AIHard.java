package tictactoe;

import java.util.ArrayList;

public class AIHard extends Player {
    Symbol opponentSymbol = getOpponentSymbol(this.symbol);

    public AIHard(Symbol symbol) {
        super(symbol);
    }

    @Override
    public void move(GameMatrix matrix) {
        int bestScore = Integer.MIN_VALUE;
        int move = 0;
        ArrayList<Integer> availSpots = matrix.checkEmptyFields(matrix.getGameMatrix());
        for (Integer spot : availSpots) {
            matrix.getGameMatrix()[spot] = this.symbol;
            int score = minimax(matrix, 0, opponentSymbol);
            matrix.getGameMatrix()[spot] = Symbol.EMPTY;
            if (score > bestScore) {
                bestScore = score;
                move = spot;
            }
        }
        matrix.setFieldOfMatrix(move, this.symbol);
    }


    private int minimax(GameMatrix matrix, int depth, Symbol playerSymbol) {
        // checks for the terminal states such as win, lose, and tie
        //and returning a value accordingly
        if (matrix.isWinner(opponentSymbol)) {
            return -10;
        } else if (matrix.isWinner(this.symbol)) {
            return 10;
        } else if (matrix.isDraw()) {
            return 0;
        }

        int bestScore;
        ArrayList<Integer> availSpots = matrix.checkEmptyFields(matrix.getGameMatrix());
        if (playerSymbol == this.symbol) {
            bestScore = Integer.MIN_VALUE;
            // get the list of available spots to simulate game
            for (Integer spot : availSpots) {
                matrix.getGameMatrix()[spot] = this.symbol;
                int score = minimax(matrix, depth + 1, opponentSymbol);
                matrix.getGameMatrix()[spot] = Symbol.EMPTY;
                bestScore = Math.max(score, bestScore);
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            // get the list of available spots to simulate game
            for (Integer spot : availSpots) {
                matrix.getGameMatrix()[spot] = opponentSymbol;
                int score = minimax(matrix, depth + 1, this.symbol);
                matrix.getGameMatrix()[spot] = Symbol.EMPTY;
                bestScore = Math.min(score, bestScore);
            }
        }
        return bestScore;

    }


    private Symbol getOpponentSymbol(Symbol mySymbol) {
        if (mySymbol == Symbol.X) {
            return Symbol.O;
        } else {
            return Symbol.X;
        }
    }
}
