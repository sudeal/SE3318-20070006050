package org.example;import java.util.ArrayList;import java.util.List;/** * Main application class for the car rental system. */public class App {    /**     * Main method to demonstrate the car rental system.     *     * @param args Command line arguments (not used)     */
    public static void main(String[] args) {
        // Create sample vehicles
        List<VehicleAbstract> vehicles = new ArrayList<>();
        
        // Add luxury vehicles
        vehicles.add(new LuxuryVehicle("BMW", "750i", "ABC123", true, true));
        vehicles.add(new LuxuryVehicle("Mercedes", "S500", "DEF456", true, false));
        
        // Add economy vehicles
        vehicles.add(new EconomyVehicle("Toyota", "Prius", "XYZ789", true));
        vehicles.add(new EconomyVehicle("Honda", "Civic", "MNO321", false));

        // Create some rental records
        List<RentalRecord> rentalRecords = new ArrayList<>();

        // Process some rentals
        System.out.println("Welcome to Car Rental System\n");
        
        // Demo rental 1: Luxury car with all features
        RentalRecord rental1 = new RentalRecord("John Doe", vehicles.get(0), 5);
        rentalRecords.add(rental1);
        System.out.println("New Rental Created:");
        System.out.println(rental1);
        System.out.println("Daily Price: $" + vehicles.get(0).getDailyPrice());
        System.out.println("Total Price: $" + rental1.getTotalPrice());
        System.out.println();

        // Demo rental 2: Economy hybrid car
        RentalRecord rental2 = new RentalRecord("Jane Smith", vehicles.get(2), 3);
        rentalRecords.add(rental2);
        System.out.println("New Rental Created:");
        System.out.println(rental2);
        System.out.println("Daily Price: $" + vehicles.get(2).getDailyPrice());
        System.out.println("Total Price: $" + rental2.getTotalPrice());
        System.out.println();

        // Print summary of all rentals
        System.out.println("Current Rental Records:");
        for (RentalRecord record : rentalRecords) {
            System.out.println("- " + record);
        }

        // Print available vehicles
        System.out.println("\nAvailable Vehicles:");
        for (VehicleAbstract vehicle : vehicles) {
            System.out.printf("- %s %s (%s) - Daily Rate: $%.2f%n",
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getLicensePlate(),
                vehicle.getDailyPrice());
        }
    }
}
