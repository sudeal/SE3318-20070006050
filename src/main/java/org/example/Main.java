package org.example;

/**
 * Main class to demonstrate the Character Battle game.
 */
public class Main {
    /**
     * Main method to run the Character Battle game.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Character Battle!");

        // Create two characters (using anonymous class for demonstration)
        Character warrior = new Character("Warrior", 100, 20, 10) {
            @Override
            public int attack(Character target) {
                int damage = this.getAttackPower();
                System.out.printf("%s attacks %s for %d damage!%n", 
                    this.getName(), target.getName(), damage);
                return damage;
            }
        };

        Character mage = new Character("Mage", 80, 30, 5) {
            @Override
            public int attack(Character target) {
                int damage = this.getAttackPower();
                System.out.printf("%s casts a spell on %s for %d damage!%n", 
                    this.getName(), target.getName(), damage);
                return damage;
            }
        };

        // Simulate a battle
        System.out.println("\nBattle Start!");
        System.out.printf("%s (HP: %d) vs %s (HP: %d)%n", 
            warrior.getName(), warrior.getHealth(),
            mage.getName(), mage.getHealth());

        // First round
        int damage = warrior.attack(mage);
        int actualDamage = mage.defend(damage);
        System.out.printf("%s takes %d damage! Remaining HP: %d%n", 
            mage.getName(), actualDamage, mage.getHealth());

        // Second round
        damage = mage.attack(warrior);
        actualDamage = warrior.defend(damage);
        System.out.printf("%s takes %d damage! Remaining HP: %d%n", 
            warrior.getName(), actualDamage, warrior.getHealth());
    }
}