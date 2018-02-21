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

    public void setBalance(int balance){
        game.setBalance(balance);
    }

    public void setBet(int bet){
        game.setBet(bet);
    }

    public void setWinnings(int winnings){
        game.setWinnings(winnings);
    }

    public int getBet(){
        return game.getBet();
    }

    public int getBalance(){
        return game.getBalance();
    }

    public int getWinnings(){
        return game.getWinnings();
    }

    public int getJackpot(){
        return game.getJackpot();
    }

    public void setJackpot(int j){
        game.setJackpot(j);
    }

}
