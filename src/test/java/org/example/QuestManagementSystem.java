package org.example;

public class QuestManagementSystem {
    public static void main(String[] args) {

        Mentor gandalf = new Mentor("Gandalf", "The Grey");

        // Create Adventurers
        Adventurer frodo = new Adventurer("Frodo Baggins", "Ring-bearer", "Hobbit");
        Adventurer aragorn = new Adventurer("Aragorn", "King of Gondor", "Man");
        Adventurer legolas = new Adventurer("Legolas", "Elven Prince", "Elf");
        Adventurer gimli = new Adventurer("Gimli", "Son of Glóin", "Dwarf");

        // Create Quests
        Quest destroyRing = new Quest("Destroy the One Ring", "Hard");
        Quest defendHelmsDeep = new Quest("Defend Helm's Deep", "Medium");

        // Mentor guides quests
        gandalf.guideQuest(destroyRing);

        // Adventurers join quests
        frodo.joinQuest(destroyRing);
        aragorn.joinQuest(defendHelmsDeep);
        legolas.joinQuest(defendHelmsDeep);
        gimli.joinQuest(defendHelmsDeep);

        // Display quest details with adventurers
        System.out.println("Quest: " + destroyRing);
        for (Adventurer adventurer : destroyRing.getAdventurers()) {
            System.out.println("Adventurer in Destroy the One Ring: " + adventurer);
        }

        System.out.println("Quest: " + defendHelmsDeep);
        for (Adventurer adventurer : defendHelmsDeep.getAdventurers()) {
            System.out.println("Adventurer in Defend Helm's Deep: " + adventurer);
        }
    }
}
