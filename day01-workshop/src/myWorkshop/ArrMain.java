public class ArrMain {
    public static void main(String[] args) {
        
        String[] name = new String[3];

        String[][] names = new String[3][2]; 
        // An array of array 2 dimensions
        // outer array is 3
        // inner array is 2


name[0] = "apples";
name[1] = "oranges";
name[2] = "bananas";

names[0][0] = "a";
names[0][1] = "b";
names[0][2] = "c";
names[1][0] = "d";
names[1][1] = "e";
names[1][2] = "f";

int i = 0;
while(i < names.length) {
    int j = 0;
    while (j < names[i].length) {
        System.out.printf("%s, %s, %s", i, j, names[i][j]);
        j += 1;
    }
    i += 1;
}

System.out.println("Print" + name.length);

/*for (String i : name) {
    System.out.print("Print " + i + "\n");
}*/


while ( i < name.length) {
    System.out.println("Print name: " + name[i]);
    i += 1;
}

    }
}
