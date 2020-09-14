package tictactoe;

public class Player {

    protected void move(GameMatrix matrix) {

    }

    public static Player createPlayer (Symbol symbol, String request){
        switch (request) {
            case "user": {
                return new User(symbol);
            }
            case "easy": {
                return  new AIEasy(symbol);
            }
            case "medium": {
                return  new AIMedium(symbol);
            }
            case "hard": {
                return  new AIHard(symbol);
            }
            default: {
                return  new Player();
            }
        }
    }
}
