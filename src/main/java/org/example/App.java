package org.example;

/**
 * Main application class for Lord of the Rings simulation.
 */
public class App {
    /**
     * Main method to run the application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", "Hobbit", 50);
        frodo.printDetails();

        MiddleEarthMap map = new MiddleEarthMap();
        map.navigate("Mordor", false);

        Quest quest = new Quest();
        quest.completeQuest(100, true);
    }
}
