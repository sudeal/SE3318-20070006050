package org.example;
import java.util.ArrayList;
import java.util.List;
public class Quest {
    private String name;
    private String difficulty;
    private Mentor mentor;
    private List<Adventurer> adventurers;

    public Quest(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.adventurers = new ArrayList<>();
    }

    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
