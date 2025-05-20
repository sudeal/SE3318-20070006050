package org.example;

/**
 * Class demonstrating practical usage of loops with proper checkstyle compliance.
 */
public class ExampleUsage {
    
    /**
     * Filters and counts even numbers from 1 to 20.
     * @return count of even numbers
     */
    public int filterAndCountEvenNumbers() {
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = i + 1;
        }
        
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the sum of diagonal elements in a 3x3 matrix.
     * @return sum of diagonal elements
     */
    public int matrixDiagonalSum() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
