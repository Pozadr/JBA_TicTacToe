package tictactoe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();

        game.printMatrix(); // init empty board | later main menu

        while (true) {
            game.userMove();
            game.printMatrix();
            if (game.checkWhoWonTheGame()) {
                break;
            }
            game.AiMoveEasy();
            game.printMatrix();
            if (game.checkWhoWonTheGame()) {
                break;
            }
        }
    }
}
