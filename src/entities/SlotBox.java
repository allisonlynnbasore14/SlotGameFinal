package entities;

import starter.Handler;

import java.awt.*;

public class SlotBox extends Entity{

    int BOXWIDTH = 200;
    int BOXHEIGHT = 200;

    public SlotBox(Handler handler, float x, float y, String type, Color color){
        super(handler, x, y, type, color);
    }

    public void tick(){

    }


    public void render(Graphics g){
        g.setColor(color);
        g.drawRect((int)x,(int)y,BOXWIDTH, BOXHEIGHT);
    }

}
