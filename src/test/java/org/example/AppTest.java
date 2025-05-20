package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case.
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * Returns the suite of tests being tested.
     * @return Test suite
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Tests the basic application functionality.
     */
    public void testApp() {
        assertTrue(true);
    }
}
