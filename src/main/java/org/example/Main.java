package org.example;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        HogwartsStudent harry = new HogwartsStudent("Harry Potter", "Gryffindor", 1);
        HogwartsStudent hermione = new HogwartsStudent("Hermione Granger", "Gryffindor", 1);
        HogwartsStudent draco = new HogwartsStudent("Draco Malfoy", "Slytherin", 1);


        harry.learnSpell("Expelliarmus");
        hermione.learnSpell("Alohomora");
        draco.learnSpell("Avada Kedavra");


        Spellbook spellbook = new Spellbook();
        spellbook.addSpell("Expelliarmus");
        spellbook.addSpell("Alohomora");
        spellbook.addSpell("Avada Kedavra");


        MagicClassroom classroom = new MagicClassroom();
        classroom.addStudent(harry);
        classroom.addStudent(hermione);
        classroom.addStudent(draco);


        System.out.println("Harry knows Expelliarmus: " + harry.knowsSpell("Expelliarmus"));
        System.out.println("Hermione knows Alohomora: " + hermione.knowsSpell("Alohomora"));


        WizardExam exam = new WizardExam(Arrays.asList("Expelliarmus", "Alohomora"));
        exam.evaluate(harry);


        Duel.start(harry, hermione, "Expelliarmus");
        Duel.start(harry, draco, "Avada Kedavra");
    }

}
