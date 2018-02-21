package gameMech;

import starter.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameMech {

    //TODO: add spin results to handler

    // Pass the game state here?

    int bet;
    int balance = 1000;
    int NUMBEROFWHEELS = 3;
    double jackpot = 10000;
    Handler handler;
    boolean running;
    String input = "";

    public GameMech(Handler handler){
        running = handler.isRunning();
        this.handler = handler;
    }


    public void tick(){
        while(running){
            // get user input
            //getInput();
            setBet();
        }
    }

    public void setBet(){
        System.out.print("What would you like to bet? ");
        getInput();

        bet = Integer.parseInt(input);
        handler.setBet(bet);
        spin();
    }

    public void spin(){
        pay();

        HashMap<Integer, Integer> holder = new HashMap();


        for(int i = 0; i < NUMBEROFWHEELS; i++){
            Random rand = new Random();
            int  n = rand.nextInt(10) + 1; // 10 is max and 1 is the min
            if(holder.get(n)==null){
                holder.put(n, 1);
            }else{
                holder.put(n, 2);
            }
        }

        Random rand = new Random();
        int  p = rand.nextInt(10) + 1; // 10 is max and 1 is the min
        if(p > 5){
            increaseJackpot();
        }


        int total = 0;
        for(Map.Entry<Integer, Integer> entry : holder.entrySet()) {
            balance = balance + (entry.getValue() - 1) * bet;
            total = total + (entry.getValue() - 1) * bet;
        }
        handler.setWinnings(total);
        System.out.println("Your current balance is...." + balance);
        running =false;
    }

    public void getInput(){

//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Enter a number: ");
//        int n = reader.nextInt(); // Scans the next token of the input as an int.
////once finished
//        reader.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            input = reader.readLine();
        }
        catch(IOException ex){
            System.out.println (ex.toString());
            System.out.println("Can you say that again? ");
        }

    }

    public void pay(){

        balance = balance - bet;
        handler.setBalance(balance);
        System.out.println("AT PAY" + balance);
    }

    public void increaseJackpot(){
        jackpot = jackpot + jackpot * 0.3;
        handler.setJackpot((int) jackpot);
    }

    public void setRunning(boolean r){
        running = r;
    }

    public boolean isRunning(){
        return running;
    }



}
