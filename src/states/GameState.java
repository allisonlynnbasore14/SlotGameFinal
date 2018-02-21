package states;

import entities.SlotBox;
import starter.Handler;

import java.awt.*;

public class GameState extends State{

    SlotBox firstBox;
    public GameState(Handler handler){
        super(handler); // getting it from the state class
        firstBox = new SlotBox(handler, 100, 100,"CIIk", Color.BLUE);

    }

    public void tick(){
        // object.tick();
        firstBox.tick();
    }


    public void render(Graphics g){
        // object.render(g);
        firstBox.render(g);


    }

}
