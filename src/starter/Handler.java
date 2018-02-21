package starter;

public class Handler {

    private Game game;

    public Handler(Game game){
        this.game = game;
    }

    // TODO: add Keymanager

    public int getWidth(){
        return game.getWidth();
    }

    public boolean isRunning(){
        return game.isRunning();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame(){
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
