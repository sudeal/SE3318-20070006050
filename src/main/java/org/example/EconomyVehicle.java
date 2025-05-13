package org.example;

/**
 * Represents an economy vehicle in the rental system.
 */
public class EconomyVehicle implements VehicleAbstract {
    private static final double BASE_PRICE = 50.0;
    private static final double HYBRID_PRICE = 10.0;

    private final String brand;
    private final String model;
    private final String licensePlate;
    private final boolean isHybrid;

    /**
     * Constructs an economy vehicle.
     *
     * @param brand The brand name
     * @param model The model name
     * @param licensePlate The license plate number
     * @param isHybrid Whether the vehicle is hybrid
     */
    public EconomyVehicle(String brand, String model, String licensePlate, boolean isHybrid) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.isHybrid = isHybrid;
    }

    @Override
    public double getDailyPrice() {
        return BASE_PRICE + (isHybrid ? HYBRID_PRICE : 0);
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Checks if the vehicle is hybrid.
     *
     * @return true if the vehicle is hybrid, false otherwise
     */
    public boolean isHybrid() {
        return isHybrid;
    }
}