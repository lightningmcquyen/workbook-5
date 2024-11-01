import java.util.ArrayList;
import java.util.List;

public class AssetManager {
    public static void main(String[] args) {
        List<Asset> myAssets = new ArrayList<>();

        // Create and add House assets
        House myHouse1 = new House("Family Home", "03-09-2001", 200000, "123 Elm St", 1, 2000, 5000);
        House myHouse2 = new House("Vacation Home", "04-07-2027", 1000000, "456 Ocean Blvd", 1, 3000, 7000);
        myAssets.add(myHouse1);
        myAssets.add(myHouse2);

        // Create and add Vehicle assets
        Vehicle quyensVehicle1 = new Vehicle("Sedan", "12-17-2017", 35000, "Lexus IS-250", 2014, 16000);
        Vehicle quyensVehicle2 = new Vehicle("Truck", "06-17-2028", 60000, "Toyota Tacoma", 2024, 9000);
        Vehicle quyensVehicle3 = new Vehicle("SUV", "08-08-2025", 90000, "Porsche Macan", 2024, 1000);
        myAssets.add(quyensVehicle1);
        myAssets.add(quyensVehicle2);
        myAssets.add(quyensVehicle3);


        // Loop through the asset collection
        for (Asset asset : myAssets) {
            if (asset instanceof House house) {
                System.out.println("Description: " + house.getDescription());
                System.out.println("Date Acquired: " + house.getDataAcquired());
                System.out.println("Original Cost: $" + house.getOriginalCost());
                System.out.println("Current Value: $" + house.getValue());
                System.out.println("Address: " + house.getAddress());
                System.out.println("..........");
            } else if (asset instanceof Vehicle vehicle) {
                System.out.println("Description: " + vehicle.getDescription());
                System.out.println("Date Acquired: " + vehicle.getDataAcquired());
                System.out.println("Original Cost: $" + vehicle.getOriginalCost());
                System.out.println("Current Value: $" + vehicle.getValue());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Odometer: " + vehicle.getOdometer());
            }
        }
    }
}