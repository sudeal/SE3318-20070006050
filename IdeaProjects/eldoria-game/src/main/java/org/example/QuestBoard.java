package org.example;

public class QuestBoard {
    public void assignQuest(Questable questable, String questName) {
        questable.acceptQuest(questName);
    }
}
