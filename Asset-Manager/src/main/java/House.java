public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dataAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dataAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        double valuePerSquareFoot;

        // Determine value per square foot based on condition
        switch (condition) {
            case 1: // Excellent
                valuePerSquareFoot = 180;
                break;
            case 2: // Good
                valuePerSquareFoot = 130;
                break;
            case 3: // Fair
                valuePerSquareFoot = 90;
                break;
            case 4: // Poor
                valuePerSquareFoot = 80;
                break;
            default:
                valuePerSquareFoot = 0; // Handle invalid condition
                break;
        }

        // Calculate the total value based on square footage and lot size
        double value = (valuePerSquareFoot * squareFoot) + (0.25 * lotSize);

        return value;
    }

    @Override
    public String toString() {
        return "House{" +
                "description='" + getDescription() + '\'' +
                ", dataAcquired='" + getDataAcquired() + '\'' +
                ", originalCost=" + getOriginalCost() +
                ", address='" + address + '\'' +
                ", condition=" + condition +
                ", squareFoot=" + squareFoot +
                ", lotSize=" + lotSize +
                '}';
    }
}