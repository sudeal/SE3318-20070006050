package org.example;

/**
 * Represents a quest in the Lord of the Rings universe.
 */
public class Quest {
    private String type;
    private int difficulty;

    /**
     * Determines if a quest is completed successfully.
     * @param points Quest points earned
     * @param isRingBearer Whether the character is a ring bearer
     * @return true if quest is completed, false otherwise
     */
    public boolean completeQuest(int points, boolean isRingBearer) {
        boolean isQualified = points > 0 && isRingBearer 
            || points < -100 
            || points == 42;

        if (points > 50 && points < 100 && points % 2 == 0 && isQualified) {
            System.out.println("Qualified");
        }

        return points >= 100;
    }
}