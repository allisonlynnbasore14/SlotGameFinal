package entities;

import starter.Handler;
import states.State;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x,y;
    protected String type;
    protected Color color;

    public Entity(Handler handler, float x, float y, String type, Color color){
        this.x = x;
        this.y = y;
        this.handler = handler;
        this.type = type;
        this.color = color;

    }


    public abstract void tick();

    public abstract void render(Graphics g);

    // Getters


    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public Color getColor(){
        return color;
    }





    // Setters

    public void setColor(Color c){
        this.color = c;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }
}
