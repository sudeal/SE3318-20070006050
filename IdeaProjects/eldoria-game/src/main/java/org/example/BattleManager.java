package org.example;

public class BattleManager {
    public void startBattle(Hero hero, Enemy enemy) {
        System.out.println("Battle starts between " + hero.getName() + " (Level " + hero.getLevel() + ") and " + enemy.getName() + " (Level " + enemy.getLevel() + ")");

        // Battle logic (for simplicity, assume hero wins)
        System.out.println(hero.getName() + " defeats " + enemy.getName());
    }
}
