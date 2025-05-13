package org.example;

/**
 * Abstract interface for vehicles in the rental system.
 */
public interface VehicleAbstract {
    /**
     * Gets the daily rental price including features.
     * @return The total daily rental price
     */
    double getDailyPrice();

    /**
     * Gets the brand of the vehicle.
     * @return The brand name
     */
    String getBrand();

    /**
     * Gets the model of the vehicle.
     * @return The model name
     */
    String getModel();

    /**
     * Gets the license plate of the vehicle.
     * @return The license plate number
     */
    String getLicensePlate();
}