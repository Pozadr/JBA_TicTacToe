package tictactoe;

import java.util.ArrayList;

public class AIHard extends Player {

    public AIHard (Symbol symbol) {
        super(symbol);
    }

    @Override
    public void move(GameMatrix matrix) {
        ArrayList<Integer> emptyFields = matrix.checkEmptyFields();
        for (int emptyFiled : emptyFields) {
            System.out.println(emptyFiled);
        }

    }


}
