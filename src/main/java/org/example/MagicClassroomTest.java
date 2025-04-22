package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MagicClassroomTest {

    private MagicClassroom classroom;
    private HogwartsStudent harry;
    private HogwartsStudent hermione;
    private HogwartsStudent draco;

    @BeforeEach
    public void setUp() {
        classroom = new MagicClassroom();

        harry = new HogwartsStudent("Harry", "Gryffindor", 3);
        hermione = new HogwartsStudent("Hermione", "Gryffindor", 3);
        draco = new HogwartsStudent("Draco", "Slytherin", 3);

        harry.learnSpell("Expelliarmus");
        hermione.learnSpell("Alohomora");

        classroom.addStudent(harry);
        classroom.addStudent(hermione);
        classroom.addStudent(draco);
    }

    @Test
    public void testAddValidStudent() {
        HogwartsStudent luna = new HogwartsStudent("Luna", "Ravenclaw", 4);
        boolean result = classroom.addStudent(luna);
        assertTrue(result);
        assertEquals("Luna", classroom.findStudent("Luna").getName());
    }

    @Test
    public void testAddNullStudent() {
        boolean result = classroom.addStudent(null);
        assertFalse(result);
    }

    @Test
    public void testFindStudentByName() {
        HogwartsStudent result = classroom.findStudent("Hermione");
        assertNotNull(result);
        assertEquals("Hermione", result.getName());
    }

    @Test
    public void testFindStudentBySpell() {
        HogwartsStudent result = classroom.findStudentBySpell("Expelliarmus");
        assertNotNull(result);
        assertEquals("Harry", result.getName());
    }

    @Test
    public void testGetStudentsByHouse() {
        List<HogwartsStudent> gryffindors = classroom.getStudentsByHouse("Gryffindor");
        assertEquals(2, gryffindors.size());
        assertTrue(gryffindors.stream().anyMatch(s -> s.getName().equals("Harry")));
    }

    @Test
    public void testGetStudentsSortedByHouse() {
        List<HogwartsStudent> sorted = classroom.getStudentsSortedByHouse();
        assertEquals(3, sorted.size());
        assertEquals("Draco", sorted.get(0).getName());  // Slytherin comes before Gryffindor
        assertEquals("Harry", sorted.get(1).getName());
        assertEquals("Hermione", sorted.get(2).getName());
    }
}