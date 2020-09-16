package tictactoe;

import java.util.Scanner;

public class User extends Player {

    public User (Symbol symbol) {
        super(symbol);
    }

    /**
     * User use two dimensional matrix to navigate fields to play.
     *
     * Two dimensional matrix:
     * (1, 3) (2, 3) (3, 3)
     * (1, 2) (2, 2) (3, 2)
     * (1, 1) (2, 1) (3, 1)
     *
     * Game one dimensional matrix to compare:
     *      0, 1, 2,
     *      3, 4, 5,
     *      6, 7, 8
     *
     * In move function there is a casting of two to one dimensional matrix.
     */
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
                        int field = castCoordinates(xCoordinate, yCoordinate);
                        if (matrix.isFieldOfMatrixFree(field)) {
                            matrix.setFieldOfMatrix(field, symbol);
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

    /**
     * Data validation is in move function.
     * @param xCoordinate - x from two dimensional matrix (x, y)
     * @param yCoordinate - y from two dimensional matrix (x, y)
     * @return - two to one dimensional matrix coordinate
     */
    private int castCoordinates(int xCoordinate, int yCoordinate) {
        switch (xCoordinate){
            case 1: {
                switch (yCoordinate){
                    case 1:  return 6;
                    case 2:  return 3;
                    default: return 0; // 3
                }
            }
            case 2: {
                switch (yCoordinate){
                    case 1:  return 7;
                    case 2:  return 4;
                    default: return 1;// 3
                }
            }
            default: { // 3
                switch (yCoordinate){
                    case 1:  return 8;
                    case 2:  return 5;
                    default: return 2;
                }
            }
        }
    }
}
