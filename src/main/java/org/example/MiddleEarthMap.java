package org.example;

/**
 * Represents the map of Middle Earth.
 */
public class MiddleEarthMap {
    /**
     * Navigates to a specific location.
     * @param location The destination
     * @param isSecretPassage Whether to use secret passages
     */
    public void navigate(String location, boolean isSecretPassage) {
        switch (location) {
            case "Mordor":
                System.out.println("Navigating to Mordor");
                if (isSecretPassage) {
                    System.out.println("Taking a secret passage");
                }
                break;
            case "Shire":
                System.out.println("Navigating to the Shire");
                break;
            case "Gondor":
                System.out.println("Navigating to Gondor");
                break;
            case "Lothlórien":
                System.out.println("Navigating to Lothlórien");
                break;
            default:
                System.out.println("Unknown location");
                break;
        }

        if (isSecretPassage) {
            System.out.println("Using secret passage");
        }
    }
}
