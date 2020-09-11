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
                        if ((player1Input.equals("user") || player1Input.equals("easy")
                                || player1Input.equals("medium") || player1Input.equals("hard"))
                         && (player2Input.equals("user") || player2Input.equals("easy")
                                || player2Input.equals("medium") || player2Input.equals("hard"))) {
                            // creating object of player1
                            switch (player1Input) {
                                case "user": {
                                    player1 = new User(Symbol.X);
                                    break;
                                }
                                case "easy": {
                                    player1 = new AIEasy(Symbol.X);
                                    break;
                                }
                                case "medium": {
                                    player1 = new AIMedium(Symbol.X);
                                    break;
                                }
                                case "hard": {
                                    player1 = new AIHard(Symbol.X);
                                    break;
                                }
                                default: {
                                    player1 = new Player();
                                }
                            }
                            // creating object of player2
                            switch (player2Input) {
                                case "user": {
                                    player2 = new User(Symbol.O);
                                    break;
                                }
                                case "easy": {
                                    player2 = new AIEasy(Symbol.O);
                                    break;
                                }
                                case "medium": {
                                    player2 = new AIMedium(Symbol.O);
                                    break;
                                }
                                case "hard": {
                                    player2 = new AIHard(Symbol.O);
                                    break;
                                }
                                default: {
                                    player2 = new Player();
                                }
                            }
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

