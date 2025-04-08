package org.example;

public class Mage extends Hero implements Questable{
    public Mage(String name, int level) {
        super(name, level);
    }

    @Override
    public void speak() {
        System.out.println("I am " + name + ", a powerful mage of level " + level + "!");
    }

    @Override
    public void acceptQuest(String questName) {
        System.out.println(name + " the mage has accepted the quest: " + questName);
    }

    public void castSpell() {
        System.out.println(name + " casts a powerful spell!");
    }
}
