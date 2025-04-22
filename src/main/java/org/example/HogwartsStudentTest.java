package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HogwartsStudentTest {

    @Test
    public void testLearnValidSpell() {
        HogwartsStudent student = new HogwartsStudent("Harry", "Gryffindor", 3);
        boolean result = student.learnSpell("Expelliarmus");
        assertTrue(result, "Valid spell should be learned successfully");
        assertTrue(student.knowsSpell("Expelliarmus"));
    }

    @Test
    public void testLearnNullSpell() {
        HogwartsStudent student = new HogwartsStudent("Hermione", "Gryffindor", 3);
        boolean result = student.learnSpell(null);
        assertFalse(result, "Null spell should be rejected");
    }

    @Test
    public void testLearnDuplicateSpell() {
        HogwartsStudent student = new HogwartsStudent("Ron", "Gryffindor", 3);
        student.learnSpell("Lumos");
        boolean result = student.learnSpell("Lumos");
        assertFalse(result, "Duplicate spell should not be added again");
        assertEquals(1, student.getSpellsLearned().size());
    }

    @Test
    public void testKnowsSpell() {
        HogwartsStudent student = new HogwartsStudent("Luna", "Ravenclaw", 4);
        student.learnSpell("Alohomora");
        assertTrue(student.knowsSpell("Alohomora"));
        assertFalse(student.knowsSpell("Avada Kedavra"));
    }
}