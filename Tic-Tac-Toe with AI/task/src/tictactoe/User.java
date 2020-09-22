package tictactoe;

import java.util.Scanner;

public class User extends Player {

    public User (Symbol symbol) {
        super(symbol);
    }

    @Override
    public void move(GameMatrix matrix) {
        Scanner scanner = new Scanner(System.in);
        int xCoordinate;
        int yCoordinate;

        while (true) {
            //read coordinates
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine().replaceAll(" ","");  // replaceAll to cut all spaces
            // input String should have only 2 numbers (Integers); first(1-3), second(1-3)
            if (input.length() == 2) {
                try {
                    xCoordinate = Integer.parseInt(input.substring(0, 1)); // first sign from input to xCoordinate
                    yCoordinate = Integer.parseInt(input.substring(1, 2)); // second sign from input to yCoordinate
                    // check if coordinates are not 0. Should be range <1-3>.
                    if (xCoordinate >= 1 && xCoordinate <= 3 && yCoordinate >= 1 && yCoordinate <= 3 ) {
                        // if cell is empty
                        if (matrix.isFieldOfMatrixFreeUser(xCoordinate, yCoordinate)) {
                            matrix.setFieldOfMatrixUser(xCoordinate, yCoordinate, symbol);
                            break; // break while loop
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("You should enter numbers!");
                }
            } else {
                System.out.println("Wrong input! Try again!");
            }
        }
    }
}
