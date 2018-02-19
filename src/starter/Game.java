package starter;
import display.Display;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;

public class Game implements Runnable{
    private BufferStrategy buffStrat;
    private Graphics g;
    private Display display;
    private int width, height;
    private String title;
    private boolean running = false;
    public Thread thread;

    // To do: add state


    public Game(String title, int width, int height){
        System.out.println("this is the game");
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void init(){
        // TODO: make handler,keymanager, set state
        display = new Display(title, width, height);
    }

    public void tick(){
        // TODO: tick state and tick keymanager
    }


    private void render(){
        buffStrat = display.getCanvas().getBufferStrategy();
        // a buffer strategy: how to tell the computer to draw, a buffer is a hidden computer screen inside your computer
        // without this it would glitch like old games did
        // Basically it loads a several

    // to make: frames in advance and roates the path
        // You can only do this with enough memory to hold three version of a large display object
        if(buffStrat == null){
            display.getCanvas().createBufferStrategy(2);
            // generally this is 2 or 3
            return;
        }

    // to make:

        g = buffStrat.getDrawGraphics(); // Gets the graphics object to paint on the canvas with
        g.clearRect(0,0, width, height); // must be called before anything is drawn

        //if(State.getState() != null){
         //   State.getState().render(g); // calls the rendering of the state with the graphics object
        ///}

        // Temporary testing block
        // g.setColor(Color.blue);
        // g.fillRect(30,100,40,100);

        buffStrat.show();
        g.dispose();
    }

    public void run(){
        init();
        // TODO:

        int fps = 60; // frames per second
        double timePerTic = 1000000000/ fps; // converting
        double delta = 0; // change in time variable
        long now; // time variable as a long variable
        long lastTime = System.nanoTime(); // last time variable
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();  // gets the time
            delta += (now-lastTime)/timePerTic; // calcuates time difference
            timer += (now - lastTime); // sets timer
            lastTime = now; // resets lastime

            if(delta >= 1){
                tick();
                render(); // runs next frame and resets
                ticks ++;
                delta--;
            }

            if(timer >= 1000000000){
                // System.out.println("Ticks " + ticks);
                ticks = 0;
                timer = 0; // resets
            }

        }

        stop();

        // stops the game when it is running is false

    }


    public synchronized void start(){
        // The synchronized part means that this can only be executed for one trhead at a time.
        // Also other synchronized things can only do thier thing after this one is done
        if(running){
            return; // We dont want to do anything if this thread is already running
        }
        running = true;
        thread = new Thread(this); // starts new thread
        thread.start();

    }

    public synchronized void stop(){
        if(running){
            running = false;
            try{
                thread.join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }else{
            return;
        }
    }

}
