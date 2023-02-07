package myapp;

public class Tree implements Hitable {
    private int health;
    private String name;

    public Tree() {
        this.health = 10;
        this.name = "Tree";
    }

    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hit(int damage) {
this.health -= damage;
    }

    @Override
    public String toString() {
    
        return "Tree{name=%s, health=%d}".formatted(name, health);
    }

    



    
}
