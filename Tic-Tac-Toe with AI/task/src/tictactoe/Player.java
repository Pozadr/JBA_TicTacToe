package tictactoe;

public abstract class Player {
    protected Symbol symbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    protected abstract void move(GameMatrix matrix);

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
            default: { // hard
                return  new AIHard(symbol);
            }
        }
    }
}
