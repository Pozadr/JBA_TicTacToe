package tictactoe;

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
                    }
                    else {
                        String player1Input = input[1];
                        String player2Input = input[2];
                        Player player1;
                        Player player2;
                        // input validation
                        if ((player1Input.equals("user") || player1Input.equals("easy"))
                         && (player2Input.equals("user") || player2Input.equals("easy"))) {
                            // creating object of player1
                            if (player1Input.equals("user")) {
                                player1 = new User(Symbol.X);
                            }
                            else {
                                player1 = new AIEasy(Symbol.X);
                            }

                            // creating object of player2
                            if (player2Input.equals("user")) {
                                player2 = new User(Symbol.O);
                            }
                            else {
                                player2 = new AIEasy(Symbol.O);
                            }
                            runGame(player1, player2);
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

    public static void runGame (Player p1, Player p2) {
        GameMatrix matrix = new GameMatrix();
        matrix.printMatrix(); // init empty board | later main menu
        while (true) {
            p1.move(matrix);
            matrix.printMatrix();
            if (matrix.checkWhoWonTheGame()) {
                break;
            }
            p2.move(matrix);
            matrix.printMatrix();
            if (matrix.checkWhoWonTheGame()) {
                break;
            }
        }
    }
}

