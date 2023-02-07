import java.io.Console;
import java.util.Random;


public class Main {
    
    public static void main(String[] args) {
        
        // Create an instance of Random
        Random rand = new Random();
        // Generate a random number between 0 and 10
        int toGuess = rand.nextInt(20) + 1;

        System.out.printf("toGuess: %d\n", toGuess);

        
        Console cons = System.console();
        int tries = 3;
        String input;
        int myGuess;
        /*String input = cons.readLine("What is your number? (%d)", tries);
        int num = Integer.parseInt(input);*/
        

        /*switch (num) {
            case 1:
                System.out.print("Wrong");
                break;
            case 2:
                System.out.print("Wrong");  
                break;
            case 9:
                System.out.print("Correct"); 
                break;
            default:
                System.out.print("Number not in here");
        }*/


        
        boolean win = false;

        while ((tries > 0 ) && (!win)){
            input = cons.readLine("What is your guess?");
           myGuess = Integer.parseInt(input);

            if (myGuess > toGuess) {
                System.out.print("Lower");
            } else if (myGuess < toGuess ) {
                System.out.print("Higher");
            } else {
                System.out.print("You win");
                win = true;
                
            }
            
            // tries = tries 
            tries -= 1;
        }
         if (!win) {
        System.out.print("You lose");
         }
    }
}
