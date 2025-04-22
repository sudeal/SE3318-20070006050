package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DuelTest {

    private HogwartsStudent harry;
    private HogwartsStudent draco;

    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        harry = new HogwartsStudent("Harry", "Gryffindor", 5);
        draco = new HogwartsStudent("Draco", "Slytherin", 5);

        harry.learnSpell("Expelliarmus");
        draco.learnSpell("Expelliarmus");

        // Konsol çıktısını yakala
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testBothKnowSpell() {
        Duel.start(harry, draco, "Expelliarmus");
        String result = output.toString().trim();
        assertTrue(
                result.contains("wins the duel with stronger magic!") ||
                        result.contains("It's a tie! Both students have equal magic strength.")
        );
    }

    @Test
    public void testOnlyOneKnowsSpell() {
        harry.learnSpell("Lumos");
        Duel.start(harry, draco, "Lumos");
        String result = output.toString().trim();
        assertEquals("Harry wins the duel!", result);
    }

    @Test
    public void testNeitherKnowsSpell() {
        Duel.start(harry, draco, "Avada Kedavra");
        String result = output.toString().trim();
        assertEquals("It's a draw! Neither student knows the spell.", result);
    }

    @Test
    public void testNullSpell() {
        Duel.start(harry, draco, null);
        String result = output.toString().trim();
        assertEquals("Invalid duel.", result);
    }

    @Test
    public void testNullStudent() {
        Duel.start(harry, null, "Expelliarmus");
        String result = output.toString().trim();
        assertEquals("Invalid duel.", result);
    }
}