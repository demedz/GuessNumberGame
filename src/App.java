import java.util.Scanner;

public class App{
    static int victoryPoints;
    public static void main(String[] args){
        victoryPoints = 50;
        Scanner scan = new Scanner(System.in);
        nextPage();
        System.out.println("Welcome to the Guess a Number!");
        System.out.println("Today you have to guess a number between 1 and 10");
        System.out.println("You can an infinite or 100 points limited game");
        System.out.println("Please select game mode. [I]nfinite of [L]imited");
        char gameMode = scan.nextLine().charAt(0);
        switch(gameMode){
            case('I'): infiniteGame(); break;
            case('L'): limitedGame(); break;
            default: System.out.println("Incorrect input");
        }
        scan.close();
    }

    public static void nextPage(){
        for(int i=0;i<40;i++){
            System.out.println();
        }
    }
    public static void limitedGame(){
        System.out.println("Every time you guess it right, you will get 10 points");
        System.out.println("You win when you have "+victoryPoints+" points");
        System.out.println("Type your name when you are ready");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        boolean running = true;
        int score = 0;
        while(running){
            nextPage();
            int computersNumber =  (int)Math.ceil(Math.random()*10);
            //System.out.println(computersNumber);
            System.out.println("Name: "+name+"\nScore: "+score);
            System.out.println("How do you think, about what number computer thinks?");
            int playersNumber = scan.nextInt();
            scan.nextLine();
            if(playersNumber == computersNumber){
                score = score + 10;
                System.out.println("Nice! It was right!");
            }else{
                System.out.println("Almost right! Computer's number is: "+computersNumber);
            }
            if(score >= victoryPoints){
                System.out.println("Congratulations! Thank you for the game! See you soon!");
                running = false;
            }else{
                System.out.println("Enter anything when you are ready for the next round");
                scan.nextLine();
            }
            scan.close();
        }
    }
    public static void infiniteGame(){
        System.out.println("Every time you guess it right, you will get 10 points");
        System.out.println("You can play as long as you wish");
        System.out.println("Type your name when you are ready");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        boolean running = true;
        int score = 0;
        char quitOrNot;
        while(running){
            nextPage();
            int computersNumber =  (int)Math.ceil(Math.random()*10);
            //System.out.println(computersNumber);
            System.out.println("Name: "+name+"\nScore: "+score);
            System.out.println("How do you think, about what number computer thinks?");
            int playersNumber = scan.nextInt();
            scan.nextLine();
            if(playersNumber == computersNumber){
                score = score + 10;
                System.out.println("Nice! It was right!");
            }else{
                System.out.println("Almost right! Computer's number is: "+computersNumber);
            }
            System.out.println("If you want to quit, enter 'Q'. If you wish to continue, enter anything else.");
            
            try{
                quitOrNot = scan.nextLine().charAt(0);
            }catch(Exception e){
                quitOrNot = 'a';
            }
            switch(quitOrNot){
                case('Q'):running = false; break;
                default:
            }
            scan.close();
        }
    }

    
}
