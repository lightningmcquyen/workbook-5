package com.pluralsight.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private static final String CONTRACTS_FILE_PATH = "src/main/resources/WorkshopFiles/contracts.csv"; // Change this to your desired path

    // Method to append a contract to the contracts file
    public void saveContract(String contractData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH, true))) { // 'true' for append mode
            writer.write(contractData); // Write the contract data
            writer.newLine(); // Add a newline for the next entry
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving contract data: " + e.getMessage());
        }
    }
}