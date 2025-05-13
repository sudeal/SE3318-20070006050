package org.example;

/**
 * Base class for all characters in the battle game.
 */
public abstract class Character {
    private String name;
    private int health;
    private int attackPower;
    private int defense;

    /**
     * Constructor for Character.
     *
     * @param name        The character's name
     * @param health      Initial health points
     * @param attackPower Attack power value
     * @param defense     Defense value
     */
    public Character(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    /**
     * Performs an attack on the target character.
     *
     * @param target The character to attack
     * @return The amount of damage dealt
     */
    public abstract int attack(Character target);

    /**
     * Reduces incoming damage using defense stat.
     *
     * @param damage The incoming damage amount
     * @return The actual damage taken after defense
     */
    public int defend(int damage) {
        int actualDamage = Math.max(1, damage - this.defense);
        this.health -= actualDamage;
        return actualDamage;
    }

    /**
     * Gets the character's name.
     *
     * @return The character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the character's current health.
     *
     * @return Current health points
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the character's attack power.
     *
     * @return Attack power value
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Gets the character's defense value.
     *
     * @return Defense value
     */
    public int getDefense() {
        return defense;
    }
}
