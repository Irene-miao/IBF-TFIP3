package myapp;

import java.io.Console;

public class Hello {
    // entry point 
    public static void main(String[] args) {
        // Get the console
        // declare s variable 
        Console cons =  System.console();
        
        // Prompt the user for an input
        String input = cons.readLine("What is your name?");
        String input2 = input.trim();
        System.out.println(input2);
        String phone = cons.readLine("Your contact number:");
        String age = cons.readLine("What is your age?");
        int myAge = Integer.parseInt(age, 0, 0, 0);
        boolean isGreater = myAge >= 30; 
        if (isGreater) {
            System.out.printf("You are older at %s\n", myAge);
        } else {
            System.out.printf("You are younger at %s", myAge);
        }

        // Print the input
        System.out.printf("Hello %s, Your phone is %s\n", input, phone);
        System.out.printf("Your age is %s\n", age);
        System.out.printf("Trimmed %s", input2);
       

        switch (input.trim().toLowerCase()) {
            case "fred":
                System.out.print("Hello");
            case "barney":
                System.out.print("Hello");  
            default:
                System.out.print("You are not fred or barney");      
        }

        
        while (myAge  > 0) {
            System.out.printf("...name: %s, age is: %d\n", input2, myAge);
            myAge = myAge + 1;
        }

    }
}
