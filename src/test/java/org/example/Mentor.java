package org.example;

import java.util.*;

public class Mentor extends Character{
    private List<Quest> questsGuided;

    public Mentor(String name, String title) {
        super(name, title);
        this.questsGuided = new ArrayList<>();
    }

    public void guideQuest(Quest quest) {
        questsGuided.add(quest);
        quest.setMentor(this);
    }

    public void guideAdventurer(Adventurer adventurer, Quest quest) {
        adventurer.joinQuest(quest);
        this.guideQuest(quest);
    }

    public List<Quest> getGuidedQuests() {
        return questsGuided;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
