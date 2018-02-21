package gameMech;

import starter.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameMech {

    // Pass the game state here?

    int bet;
    int balance = 1000;
    int NUMBEROFWHEELS = 3;
    double jackpot;
    boolean running;
    String input = "";

    public GameMech(Handler handler){
        running = handler.isRunning();

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
        spin();
    }

    public void spin(){
        pay();
        //int[] holder = new int[NUMBEROFWHEELS];
        HashMap<Integer, Integer> holder = new HashMap();


        for(int i = 0; i < NUMBEROFWHEELS; i++){
            Random rand = new Random();
            int  n = rand.nextInt(10) + 1; // 50 is max and 1 is the min
            if(holder.get(n)==null){
                holder.put(n, 1);
            }else{
                holder.put(n, 2);
            }
        }


        for(Map.Entry<Integer, Integer> entry : holder.entrySet()) {
            balance = balance + (entry.getValue() - 1) * bet;
        }
        System.out.println("Your current balance is...." + balance);
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
        System.out.println("AT PAY" + balance);
    }

    public void increaseJackpot(){
        jackpot = jackpot + jackpot * 0.3;
    }


}
