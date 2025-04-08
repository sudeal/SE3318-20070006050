package org.example;

public class Enemy extends Character{
    public Enemy(String name, int level) {
        super(name, level);
    }

    @Override
    public void speak() {
        System.out.println("I am " + name + ", a fearsome enemy of level " + level + "!");
    }
}
