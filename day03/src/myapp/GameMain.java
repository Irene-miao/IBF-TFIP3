package myapp;

import java.util.LinkedList;


import java.util.List;



public class GameMain {
    

    //entrypoint
     public static void main(String[] args) {
        
        List<Hitable> enemies = new LinkedList<>();
        
        for (int i = 0; i < 3; i++) {
            enemies.add(new Troll());
        }

enemies.add(new Tree());
enemies.add(new Gnome());

Hitable h = new Tree();

 if ( h instanceof Tree) {
    Tree t = (Tree)h;
 }

for (Hitable m: enemies) {
    System.out.printf("%s\n", m);
}

        
        /*for (int i = 0; i < enemies.size(); i++) {
            System.out.printf("%d: %s\n", i ,enemies.get(i) );
        }*/

        // for each loop
       /*  Link link = new Link();
        for (Hitable h: enemies) {
            link.hit(h);
            System.out.printf("%s\n", h);
        }*/
     }
}
