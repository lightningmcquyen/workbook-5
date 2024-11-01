package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private boolean isRunning;
    private final Scanner scanley;

    public UserInterface() {
        this.isRunning = true; // Initialize to start the loop
        this.scanley = new Scanner(System.in);
        init(); // Initialize the dealership when UserInterface is created
    }

    // Method to display vehicles
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found."); // Message if no vehicles are found
        } else {
            for (Vehicle car : vehicles) {
                System.out.println(car); // Print each vehicle
            }
        }
    }

    // Initialize dealership by loading data from the file
    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }

    // Quit the application and save the dealership data
    public void quit() {
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership); // Save dealership data
        System.out.println("""
                D & B Used Cars|111 Old Benbrook Rd|817-555-5555
                🚗 Thank you for stopping by. Please come again! 🚚
                """);
        isRunning = false; // Exit loop
    }

    // Display the menu options
    public void displayMenu() {
        System.out.println("""
                🏁 Welcome to D & B Used Cars 💨
                ================================
                (A) Display Vehicles By Price
                (B) Display Vehicles By Make/Model
                (C) Display Vehicles By Year
                (D) Display Vehicles By Color
                (E) Display Vehicles By Mileage
                (F) Display Vehicles By Vehicle Type
                (G) Display All Vehicles
                (H) Add a Vehicle
                (I) Remove a Vehicle
                (X) Quit
                ================================
                Enter your choice:
                """);
    }

    // Main display loop
    public void display() {
        while (isRunning) { // Keep the application running
            displayMenu(); // Show menu options
            String option = scanley.nextLine().toUpperCase(); // Get user input

            // Handle user choices
            switch (option) {
                case "A" -> processGetByPriceRequest();
                case "B" -> processGetByMakeModelRequest();
                case "C" -> processGetByYearRequest();
                case "D" -> processGetByColorRequest();
                case "E" -> processGetByMileageRequest();
                case "F" -> processGetByVehicleTypeRequest();
                case "G" -> processGetAllVehiclesRequest();
                case "H" -> processAddVehicleRequest();
                case "I" -> processRemoveVehicleRequest();
                case "X" -> quit(); // Call the quit method
                default -> System.out.println("Invalid option. Please choose a valid option."); // Error message
            }
        }
    }

    // Process requests based on criteria
    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanley.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanley.nextDouble();
        scanley.nextLine(); // Clear the newline

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles); // Show the results
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter vehicle make: ");
        String make = scanley.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = scanley.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles); // Show the results
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int minYear = scanley.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanley.nextInt();
        scanley.nextLine(); // Clear the newline

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles); // Show the results
    }

    public void processGetByColorRequest() {
        System.out.print("Enter vehicle color: ");
        String color = scanley.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles); // Show the results
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        double minMileage = scanley.nextDouble();
        System.out.print("Enter maximum mileage: ");
        double maxMileage = scanley.nextDouble();
        scanley.nextLine(); // Clear the newline

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles); // Show the results
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanley.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles); // Show the results
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles()); // Display all vehicles
    }

    public void processAddVehicleRequest() {
        // Get vehicle details from the user
        System.out.println("Enter VIN:");
        int vin = Integer.parseInt(scanley.nextLine());
        System.out.println("Enter Year:");
        int year = Integer.parseInt(scanley.nextLine());
        System.out.println("Enter Make:");
        String make = scanley.nextLine();
        System.out.println("Enter Model:");
        String model = scanley.nextLine();
        System.out.println("Enter Vehicle Type:");
        String vehicleType = scanley.nextLine();
        System.out.println("Enter Color:");
        String color = scanley.nextLine();
        System.out.println("Enter Odometer:");
        int odometer = Integer.parseInt(scanley.nextLine());
        System.out.println("Enter Price:");
        double price = Double.parseDouble(scanley.nextLine());

        // Create a new Vehicle object and add it to the dealership
        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Enter the VIN of the vehicle to remove:");
        int vin = Integer.parseInt(scanley.nextLine());

        if (dealership.removeVehicle(vin)) {
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }
}