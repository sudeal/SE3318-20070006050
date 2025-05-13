package org.example;

import java.time.LocalDateTime;

/**
 * Represents a rental record in the car rental system.
 */
public class RentalRecord {
    private final String renterName;
    private final VehicleAbstract vehicle;
    private final int rentalDays;
    private final LocalDateTime rentalDate;

    /**
     * Constructs a rental record.
     *
     * @param renterName The name of the person renting the vehicle
     * @param vehicle The vehicle being rented
     * @param rentalDays The number of days for the rental
     */
    public RentalRecord(String renterName, VehicleAbstract vehicle, int rentalDays) {
        this.renterName = renterName;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDateTime.now();
    }

    /**
     * Gets the name of the renter.
     *
     * @return The renter's name
     */
    public String getRenterName() {
        return renterName;
    }

    /**
     * Gets the rented vehicle.
     *
     * @return The vehicle object
     */
    public VehicleAbstract getVehicle() {
        return vehicle;
    }

    /**
     * Gets the number of rental days.
     *
     * @return The number of days
     */
    public int getRentalDays() {
        return rentalDays;
    }

    /**
     * Gets the rental start date and time.
     *
     * @return The rental datetime
     */
    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    /**
     * Calculates the total price for the rental period.
     *
     * @return The total rental price
     */
    public double getTotalPrice() {
        return vehicle.getDailyPrice() * rentalDays;
    }

    /**
     * Returns a string representation of the rental record.
     *
     * @return A string containing rental details
     */
    @Override
    public String toString() {
        return String.format(
            "Rental Record: %s, Vehicle: %s %s, Days: %d, Total Price: $%.2f",
            renterName,
            vehicle.getBrand(),
            vehicle.getModel(),
            rentalDays,
            getTotalPrice()
        );
    }
}