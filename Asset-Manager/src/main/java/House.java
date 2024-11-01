public class House extends Asset {

    private final String address;
    private final int condition;
    private final int squareFoot;
    private final int lotSize;

    public House(String description, String dataAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dataAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public double getValue() {
        double valuePerSquareFoot = switch (condition) {
            case 1 -> // Excellent
                    180;
            case 2 -> // Good
                    130;
            case 3 -> // Fair
                    90;
            case 4 -> // Poor
                    80;
            default -> 0; // Handle invalid condition
        };

        // Determine value per square foot based on condition

        // Calculate the total value based on square footage and lot size
        double value = (valuePerSquareFoot * squareFoot) + (0.25 * lotSize);

        return value;
    }

    @Override
    public String toString() {
        return super.toString() + ", House{" +
                "address='" + address + '\'' +
                ", condition=" + condition +
                ", squareFoot=" + squareFoot +
                ", lotSize=" + lotSize +
                '}';
    }
}