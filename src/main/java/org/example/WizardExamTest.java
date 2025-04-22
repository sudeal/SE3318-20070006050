package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WizardExamTest {

    @Test
    public void testPass_AllSpellsKnown() {
        HogwartsStudent student = new HogwartsStudent("Harry", "Gryffindor", 5);
        student.learnSpell("Expelliarmus");
        student.learnSpell("Lumos");

        WizardExam exam = new WizardExam(Arrays.asList("Expelliarmus", "Lumos"));

        assertTrue(exam.pass(student));
    }

    @Test
    public void testPass_MissingSpell() {
        HogwartsStudent student = new HogwartsStudent("Ron", "Gryffindor", 5);
        student.learnSpell("Lumos");

        WizardExam exam = new WizardExam(Arrays.asList("Lumos", "Alohomora"));

        assertFalse(exam.pass(student));
    }

    @Test
    public void testEvaluate_PassedOutput() {
        HogwartsStudent student = new HogwartsStudent("Hermione", "Gryffindor", 5);
        student.learnSpell("Accio");
        student.learnSpell("Alohomora");

        WizardExam exam = new WizardExam(Arrays.asList("Accio", "Alohomora"));

        // System.out çıktısını yakala
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        exam.evaluate(student);

        String result = output.toString().trim();
        assertEquals("Hermione passed the exam!", result);
    }

    @Test
    public void testEvaluate_FailedOutput() {
        HogwartsStudent student = new HogwartsStudent("Neville", "Gryffindor", 5);
        student.learnSpell("Herbivicus");

        WizardExam exam = new WizardExam(Arrays.asList("Herbivicus", "Stupefy"));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        exam.evaluate(student);

        String result = output.toString().trim();
        assertEquals("Neville failed the exam.", result);
    }
}