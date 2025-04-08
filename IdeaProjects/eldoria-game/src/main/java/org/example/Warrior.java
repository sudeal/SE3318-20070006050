package org.example;

public class Warrior extends Hero implements Questable{
    public Warrior(String name, int level) {
        super(name, level);
    }

    @Override
    public void speak() {
        System.out.println("I am " + name + ", a fierce warrior of level " + level + "!");
    }

    @Override
    public void acceptQuest(String questName) {
        System.out.println(name + " the warrior has accepted the quest: " + questName);
    }

    public void attack() {
        System.out.println(name + " attacks with a mighty blow!");
    }
}
