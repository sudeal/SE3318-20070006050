package org.example;

/**
 * Represents a luxury vehicle in the rental system.
 */
public class LuxuryVehicle implements VehicleAbstract {
    private static final double BASE_PRICE = 100.0;
    private static final double GPS_PRICE = 20.0;
    private static final double LEATHER_SEATS_PRICE = 30.0;

    private final String brand;
    private final String model;
    private final String licensePlate;
    private final boolean hasGps;
    private final boolean hasLeatherSeats;

    /**
     * Constructs a luxury vehicle.
     * @param brand The brand name
     * @param model The model name
     * @param licensePlate The license plate number
     * @param hasGps Whether the vehicle has GPS
     * @param hasLeatherSeats Whether the vehicle has leather seats
     */
    public LuxuryVehicle(String brand, String model, String licensePlate, 
                        boolean hasGps, boolean hasLeatherSeats) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.hasGps = hasGps;
        this.hasLeatherSeats = hasLeatherSeats;
    }

    @Override
    public double getDailyPrice() {
        double total = BASE_PRICE;
        if (hasGps) {
            total += GPS_PRICE;
        }
        if (hasLeatherSeats) {
            total += LEATHER_SEATS_PRICE;
        }
        return total;
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
}