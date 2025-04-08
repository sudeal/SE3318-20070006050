package org.example;

public abstract class Character {
    protected String name;
    protected int level;

    // Constructor
    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    // Abstract method
    public abstract void speak();

    // Getter methods for name and level
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
