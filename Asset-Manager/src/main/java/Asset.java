public class Asset {
    private String description;
    private String dataAcquired;
    private double originalCost;

    public Asset(String description, String dataAcquired, double originalCost) {
        this.description = description;
        this.dataAcquired = dataAcquired;
        this.originalCost = originalCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDataAcquired() {
        return dataAcquired;
    }

    public void setDataAcquired(String dataAcquired) {
        this.dataAcquired = dataAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }

    public double getValue () {
    return originalCost;
    }
}
