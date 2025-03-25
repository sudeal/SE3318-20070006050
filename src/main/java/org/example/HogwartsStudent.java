package org.example;

import java.util.ArrayList;
import java.util.List;

public class HogwartsStudent {
    private String name;
    private String house;
    private int year;
    private List<String> spellsLearned;

    // Constructor
    public HogwartsStudent(String name, String house, int year) {
        this.name = name;
        this.house = house;
        this.year = year;
        this.spellsLearned = new ArrayList<>();
    }


    public boolean learnSpell(String spell) {

        if (spell == null || spellsLearned.contains(spell)) {
            return false;
        }

        spellsLearned.add(spell);
        return true;
    }


    public boolean knowsSpell(String spell) {
        return spellsLearned.contains(spell);
    }


    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }

    public int getYear() {
        return year;
    }

    public List<String> getSpellsLearned() {
        return spellsLearned;
    }
}
