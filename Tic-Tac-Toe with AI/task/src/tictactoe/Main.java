package tictactoe;

public class Main {
    public static void main(String[] args) {
        GameMatrix matrix = new GameMatrix();
        User user = new User();
        AIEasy aiEasy = new AIEasy();

        matrix.printMatrix(); // init empty board | later main menu

        while (true) {
            user.userMove(matrix);
            matrix.printMatrix();
            if (matrix.checkWhoWonTheGame()) {
                break;
            }
            aiEasy.AiMoveEasy(matrix);
            matrix.printMatrix();
            if (matrix.checkWhoWonTheGame()) {
                break;
            }
        }
    }

}

