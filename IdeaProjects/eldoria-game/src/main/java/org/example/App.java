package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Hero mage = new Mage("Gandalf", 50);
        Hero warrior = new Warrior("Conan", 30);
        Enemy orc = new Enemy("Orc", 20);

        // Karakterlerin konuşması
        mage.speak(); // Output: I am Gandalf, a powerful mage of level 50!
        warrior.speak(); // Output: I am Conan, a fierce warrior of level 30!
        orc.speak(); // Output: I am Orc, a fearsome enemy of level 20!

        // QuestBoard ile görev atama
        QuestBoard questBoard = new QuestBoard();
        questBoard.assignQuest((Questable) mage, "Find the Lost Tome");
        questBoard.assignQuest((Questable) warrior, "Defeat the Dragon");

        // Savaş başlatma
        BattleManager battleManager = new BattleManager();
        battleManager.startBattle((Hero) mage, orc);
    }
}
