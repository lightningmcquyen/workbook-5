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
                (J) Sell a Vehicle
                (K) Lease a Vehicle
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
                case "J" -> processSellVehicleRequest();
                case "K" -> processLeaseVehicleRequest();
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



    public void processSellVehicleRequest() {
        // Get vehicle details from the user
        System.out.print("Enter date of contract (e.g., YYYY-MM-DD): ");
        String dateOfContract = scanley.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = scanley.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanley.nextLine();

        // Get the VIN of the vehicle sold
        System.out.print("Enter VIN of the vehicle sold: ");
        int vin = Integer.parseInt(scanley.nextLine());

        // Find the vehicle in the inventory
        Vehicle vehicleSold = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleSold = vehicle;
                break; // Exit the loop if the vehicle is found
            }
        }

        // Check if the vehicle was found
        if (vehicleSold == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter sale price: ");
        double salePrice = Double.parseDouble(scanley.nextLine());

        System.out.print("Do you want to finance the vehicle? (yes/no): ");
        String financeInput = scanley.nextLine();
        boolean finance = financeInput.equalsIgnoreCase("yes");

        // Create a new SalesContract object
        SalesContract salesContract = new SalesContract(dateOfContract, customerName, customerEmail, vehicleSold, salePrice, finance);
        System.out.println("Sales contract created successfully!");
    }



    public void processLeaseVehicleRequest() {
        System.out.println("Enter the VIN of the vehicle to lease:");
        int vin = Integer.parseInt(scanley.nextLine()); // Read and convert input to an int

        // Find the vehicle by VIN
        Vehicle vehicle = null; // Start with no vehicle found
        for (Vehicle v : dealership.getAllVehicles()) { // Loop through all vehicles
            if (v.getVin() == vin) { // Check if this is the right vehicle
                vehicle = v; // If found, assign it to vehicle
                break; // Exit the loop since we found the vehicle
            }
        }

        // Check if vehicle was found
        if (vehicle == null) {
            System.out.println("Vehicle with VIN " + vin + " not found."); // Inform the user
            return; // Exit the method if no vehicle was found
        }
        if (2024 - vehicle.getYear() > 3) { // If vehicle is over 3 years old
            System.out.println("This vehicle cannot be leased as it is over 3 years old.");
            return; // Exit if it cannot be leased
        }

        // Get lessee details
        System.out.print("Enter lessee's name: ");
        String lesseeName = scanley.nextLine();

        System.out.print("Enter lessee's email: ");
        String lesseeEmail = scanley.nextLine();

        // Get lease details
        System.out.print("Enter lease price: ");
        double leasePrice = Double.parseDouble(scanley.nextLine()); // convert lease price to double

        System.out.print("Enter lease term (in months): ");
        int leaseTerm = Integer.parseInt(scanley.nextLine()); // convert lease term to integer

        // Create LeaseContract with the collected information
        String dateOfContract = java.time.LocalDate.now().toString(); // Get current date
        LeaseContract leaseContract = new LeaseContract(dateOfContract, lesseeName, lesseeEmail, vehicle, leasePrice, leaseTerm);

        System.out.println("Lease recorded: " + leaseContract); // Print confirmation
    }
}