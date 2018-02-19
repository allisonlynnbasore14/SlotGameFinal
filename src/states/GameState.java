package states;

import starter.Handler;

import java.awt.*;

public class GameState extends State{

    public GameState(Handler handler){
        super(handler); // getting it from the state class

        System.out.println("Made it to the game state");

    }

    public void tick(){
        // object.tick();
    }


    public void render(Graphics g){
        // object.render(g);

        g.setColor(Color.RED);
        g.drawLine(20, 100,120, 100);
    }

}
