package org.example;

/**
 * Represents a character in the Lord of the Rings universe.
 */
public class Character {
    private String name;
    private String race;
    private int age;
    private String weapon;

    /**
     * Creates a new character.
     * @param name Character's name
     * @param race Character's race
     * @param age Character's age
     */
    public Character(String name, String race, int age) {
        this.name = name;
        this.race = race;
        this.age = age;
    }

    /**
     * Prints character details.
     */
    public void printDetails() {
        if (race.equals("Hobbit")) {
            System.out.println("Character is a Hobbit");
        } else if (age >= 50) {
            System.out.println("Character is 50 or older");
        } else if (name.equals("Frodo")) {
            System.out.println("Character is Frodo");
        }
    }

    /**
     * Sets character's weapon.
     * @param weapon The weapon to set
     */
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}