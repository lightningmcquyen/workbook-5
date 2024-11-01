public class Asset {
    private final String description;
    private final String dataAcquired;
    private final double originalCost;

    public Asset(String description, String dataAcquired, double originalCost) {
        this.description = description;
        this.dataAcquired = dataAcquired;
        this.originalCost = originalCost;
    }

    public String getDescription() {
        return description;
    }

    public String getDataAcquired() {
        return dataAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public double getValue () {
    return originalCost;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "description='" + description + '\'' +
                ", dataAcquired='" + dataAcquired + '\'' +
                ", originalCost=" + originalCost +
                '}';
    }
}