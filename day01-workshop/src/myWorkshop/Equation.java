

import java.io.Console;

public class Equation {
    public static void main(String[] args) {
        

        // Get console
        Console cons = System.console();

        // Get equ and terms
int input = Integer.parseInt(cons.readLine("How many equations? (row)"));
int secondInput = Integer.parseInt(cons.readLine("How many terms? (cols)"));


// Equations: 
 int[][] array = new int[input][secondInput];
 int[] coefficient = new int[secondInput];
 int[] dot = new int[input];

 
 String[] combo;
String s;

 // read equation
 int i = 0;
 int j = 0;
 int dotProd = 0;

 while ( i < array.length) {
    
     s = cons.readLine("Equation (%d):", i+1);
     combo = s.split(" ");
 j = 0;

// Convert string into integer
while (j < array[i].length) {
    array[i][j] = Integer.parseInt(combo[j]);
    j += 1;
}
i += 1;

// Read coeffcient
s = cons.readLine("Coefficent: ");
combo = s.split(" ");
j = 0;
while (j < coefficient.length){
   coefficient[j] = Integer.parseInt(combo[j]);
   j += 1;
 }

 i = 0;
 while ( i < array.length) {
    j = 0;
    dotProd = 0;
    while (j < array[i].length) {
        dotProd += array[i][j] * coefficient[j];
        j++;

    }
    dot[i] = dotProd;
    i++;

    System.out.println("Dot: ");
    i = 0;
    while (i < dot.length) {
System.out.println();
    }
 }
}
 /* 
System.out.print(s);
String[] temp = s.split(",");
System.out.print(temp);

    for (int i = 0; i < array.length; i++) {
 for (int j = 0; j < array[i].length; j++) {
    for (int m = 0; m < temp.length; m++) {
   int result = array[i][j] * Integer.parseInt(temp[m]); 

System.out.print(result);*/
    }
 }
    

