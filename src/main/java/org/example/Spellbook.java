package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Spellbook {
    private List<String> allSpells;
    public Spellbook() {
        this.allSpells = new ArrayList<>();
    }


    public void addSpell(String spell) {
        allSpells.add(spell);
    }


    public String getSpell(int index) {

        if (index >= 0 && index < allSpells.size()) {

            return allSpells.get(index);
        }
        return null;
    }


    public List<String> getSpellsByPrefix(String prefix) {

        if (prefix == null) {
            return new ArrayList<>();
        }

        return allSpells.stream()
                .filter(spell -> spell.startsWith(prefix))
                .collect(Collectors.toList());
    }
}
