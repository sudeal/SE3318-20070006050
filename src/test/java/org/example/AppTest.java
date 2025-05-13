package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Smoke tests for the car rental system.
 */
public class AppTest extends TestCase {
    private LuxuryVehicle luxuryCar;
    private EconomyVehicle economyCar;
    private RentalRecord rentalRecord;

    /**
     * Create the test case.
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Setup test data before each test.
     */
    protected void setUp() {
        luxuryCar = new LuxuryVehicle("BMW", "750i", "ABC123", true, true);
        economyCar = new EconomyVehicle("Toyota", "Prius", "XYZ789", true);
        rentalRecord = new RentalRecord("John Doe", luxuryCar, 5);
    }

    /**
     * Smoke test for luxury vehicle creation and pricing.
     */
    public void testLuxuryVehicle() {
        assertEquals("BMW", luxuryCar.getBrand());
        assertEquals("750i", luxuryCar.getModel());
        assertEquals("ABC123", luxuryCar.getLicensePlate());
        assertEquals(150.0, luxuryCar.getDailyPrice()); // Base(100) + GPS(20) + Leather(30)
    }

    /**
     * Smoke test for economy vehicle creation and pricing.
     */
    public void testEconomyVehicle() {
        assertEquals("Toyota", economyCar.getBrand());
        assertEquals("Prius", economyCar.getModel());
        assertEquals("XYZ789", economyCar.getLicensePlate());
        assertEquals(60.0, economyCar.getDailyPrice()); // Base(50) + Hybrid(10)
    }

    /**
     * Smoke test for rental record creation and total price calculation.
     */
    public void testRentalRecord() {
        assertEquals("John Doe", rentalRecord.getRenterName());
        assertEquals(5, rentalRecord.getRentalDays());
        assertEquals(750.0, rentalRecord.getTotalPrice()); // 150 * 5 days
    }

    /**
     * Smoke test for vehicle availability.
     */
    public void testVehicleAvailability() {
        assertTrue(luxuryCar instanceof VehicleAbstract);
        assertTrue(economyCar instanceof VehicleAbstract);
    }
}
