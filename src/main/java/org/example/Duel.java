package org.example;
import java.util.Random;

public class Duel {
    public static void start(HogwartsStudent s1, HogwartsStudent s2, String spell) {

        if (s1 == null || s2 == null || spell == null) {
            System.out.println("Invalid duel.");
            return;
        }


        if (!s1.knowsSpell(spell) && !s2.knowsSpell(spell)) {
            System.out.println("It's a draw! Neither student knows the spell.");
        } else if (!s1.knowsSpell(spell)) {
            System.out.println(s2.getName() + " wins the duel!");
        } else if (!s2.knowsSpell(spell)) {
            System.out.println(s1.getName() + " wins the duel!");
        } else {

            Random random = new Random();
            int s1Strength = random.nextInt(100);
            int s2Strength = random.nextInt(100);

            if (s1Strength > s2Strength) {
                System.out.println(s1.getName() + " wins the duel with stronger magic!");
            } else if (s1Strength < s2Strength) {
                System.out.println(s2.getName() + " wins the duel with stronger magic!");
            } else {
                System.out.println("It's a tie! Both students have equal magic strength.");
            }
        }
    }
}
