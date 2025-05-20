package org.example;

/**
 * Main application class demonstrating loop control and usage examples.
 */
public class App {
    /**
     * Main method to run the demonstrations.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LoopControl loopControl = new LoopControl();
        ExampleUsage exampleUsage = new ExampleUsage();

        // Demonstrating correct variable usage
        System.out.println("Demonstrating correct variable usage:");
        loopControl.correctVariableUsage();

        // Task 1: Sum of squares demonstration
        System.out.println("\nSum of squares (1-10):");
        System.out.println("Result: " + loopControl.sumOfSquares());
        
        // Task 2: Triangle pattern
        System.out.println("\nPrinting triangle pattern:");
        loopControl.printTriangle();
        
        // Task 3: Incorrect loop control modification
        System.out.println("\nDemonstrating incorrect loop control modification:");
        loopControl.modifyIndexIncorrectly();
        
        // Task 4: Even numbers filtering
        System.out.println("\nFiltering even numbers (1-20):");
        System.out.println("Count: " + exampleUsage.filterAndCountEvenNumbers());
        
        // Task 5: Matrix diagonal sum
        System.out.println("\nMatrix diagonal sum:");
        System.out.println("Sum: " + exampleUsage.matrixDiagonalSum());
    }
}
