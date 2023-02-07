public class ArrMain {
    public static void main(String[] args) {
        
        /*String[] name = new String[3];

        name[0] = "apples";
        name[1] = "oranges";
        name[2] = "bananas";

        System.out.printf("Array size: %d\n", name.length);
        int i = 0;
        while (i < name.length) {
System.out.printf("[%d]  %s\n", i, name[i]);
i += 1;
        }*/

         String[][] names = new String[2][3]; 
        // An array of array 2 dimensions
        // outer array is 3
        // inner array is 2

names[0][0] = "a";
names[0][1] = "b";
names[0][2] = "c";
names[1][0] = "d";
names[1][1] = "e";
names[1][2] = "f";

int m = 0;
while(m < names.length) {
    int j = 0;
    while (j < names[m].length) {
        System.out.printf("%s, %s, %s", m, j, names[m][j]);
        j += 1;
    }
    m += 1;
}



/*for (String i : name) {
    System.out.print("Print " + i + "\n");
}*/


    }
}
