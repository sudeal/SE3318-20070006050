package org.example;

/**
 * Class demonstrating loop control patterns and checkstyle rules.
 */
public class LoopControl {
    
    /**
     * Demonstrates correct variable usage in loops.
     */
    public void correctVariableUsage() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Value: " + i);
        }
    }

    /**
     * Calculates sum of squares for first 10 positive integers.
     * @return sum of squares
     */
    public int sumOfSquares() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i * i;
        }
        return sum;
    }

    /**
     * Prints a right-angled triangle pattern using asterisks.
     */
    public void printTriangle() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Demonstrates incorrect modification of loop control variable.
     */
    public void modifyIndexIncorrectly() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Current value: " + i);
            if (i == 2) {
                i++; // Violation of ModifiedControlVariable
            }
        }
    }
}
