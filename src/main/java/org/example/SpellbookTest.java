package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpellbookTest {

    private Spellbook spellbook;

    @BeforeEach
    public void setUp() {
        spellbook = new Spellbook();
        spellbook.addSpell("Alohomora");
        spellbook.addSpell("Accio");
        spellbook.addSpell("Avada Kedavra");
        spellbook.addSpell("Expelliarmus");
    }

    @Test
    public void testGetSpell_ValidIndex() {
        String spell = spellbook.getSpell(1);
        assertEquals("Accio", spell);
    }

    @Test
    public void testGetSpell_InvalidIndex() {
        String spell = spellbook.getSpell(-1);
        assertNull(spell);

        spell = spellbook.getSpell(100);  // out of bounds
        assertNull(spell);
    }

    @Test
    public void testGetSpellsByPrefix_ExactMatch() {
        List<String> result = spellbook.getSpellsByPrefix("Alo");
        assertEquals(1, result.size());
        assertTrue(result.contains("Alohomora"));
    }

    @Test
    public void testGetSpellsByPrefix_EmptyPrefix() {
        List<String> result = spellbook.getSpellsByPrefix("");
        assertEquals(4, result.size(), "Empty prefix should return all spells");
    }

    @Test
    public void testGetSpellsByPrefix_NoMatch() {
        List<String> result = spellbook.getSpellsByPrefix("Zzz");
        assertTrue(result.isEmpty(), "No spell should match this prefix");
    }

    @Test
    public void testGetSpellsByPrefix_NullPrefix() {
        List<String> result = spellbook.getSpellsByPrefix(null);
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Null prefix should return empty list");
    }
}