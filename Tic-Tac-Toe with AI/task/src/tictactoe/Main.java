package tictactoe;

import tictactoe.players.Player;
import tictactoe.matrix.GameMatrix;
import tictactoe.matrix.Symbol;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input command: ");
            try {
                String[] input = scanner.nextLine().split(" ");
                if (input[0].equals("start")){
                    if (input.length < 2) {
                        System.out.println("Bad parameters!");
                    }git
                    else {
                        String player1Input = input[1];
                        String player2Input = input[2];
                        // input validation
                        if ((player1Input.equals("user") || player1Input.equals("easy")
                                || player1Input.equals("medium") || player1Input.equals("hard"))
                         && (player2Input.equals("user") || player2Input.equals("easy")
                                || player2Input.equals("medium") || player2Input.equals("hard"))) {
                            // creating object of player1
                            Player player1 = Player.createPlayer(Symbol.X, player1Input);
                            // creating object of player2
                            Player player2 = Player.createPlayer(Symbol.O, player2Input);
                            // ---------------------- RUN GAME ----------------------
                            runGame(player1, player2);
                            // ----------------------          ----------------------
                        }
                        else {
                            System.out.println("Bad parameters!");
                        }
                    }
                }
                // only "exit" command can finish the game
                else if (input[0].equals("exit")) {
                    break;
                }
                else {
                    System.out.println("Bad parameters!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Bad parameters!");
            }
        }
    }

    private static void runGame (Player p1, Player p2) {
        GameMatrix matrix = new GameMatrix();
        matrix.printMatrix(); // init empty board | later main menu
        while (true) {
            p1.move(matrix);
            matrix.printMatrix();
            if (matrix.isWinner(p1.symbol)) {
                System.out.println(p1.symbol.getSymbol() + " wins");
                break;
            } else if (matrix.isDraw()) {
                System.out.println("Draw");
                break;
            }
            p2.move(matrix);
            matrix.printMatrix();
            if (matrix.isWinner(p2.symbol)) {
                System.out.println(p2.symbol.getSymbol() + " wins");
                break;
            } else if (matrix.isDraw()) {
                System.out.println("Draw");
                break;
            }
        }
    }

}

