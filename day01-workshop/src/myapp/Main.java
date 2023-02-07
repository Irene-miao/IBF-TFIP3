import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        
        ArrayList<String> Cart = new ArrayList<>();
        

        boolean flag = true;

        while (flag) {
            System.out.print("Welcome to your shopping cart\n");
            switch (s.next()) {
                case "list" -> listItems(Cart);
                case "add" -> addItems(Cart);
                case "remove" -> removeItems(Cart);
                default -> flag = false;
            }
        }
          
    }

    private static void addItems(ArrayList<String> Cart) {
        String[] items = s.nextLine().split(",");
       // Cart.addAll(List.of(items));

       for (String i : items){
        String trimmed = i.trim();
        if (Cart.indexOf(trimmed) < 0) {
            Cart.add(trimmed);
        }
        
       }
      
       System.out.print(List.of(items) + " addedto cart\n");
    }

    private static void listItems(ArrayList<String> Cart){
        if (Cart.isEmpty()) {
 System.out.printf("Your cart is empty\n");
        } else {
  System.out.print(Cart);
        }
    }

    private static void removeItems(ArrayList<String> Cart) {
String[] items = s.nextLine().split(",");

for (String i : items) {
    String trimmed = i.trim();
    Cart.remove(trimmed);
    
}

    System.out.print(List.of(items) + " removed from cart\n");

    }
}