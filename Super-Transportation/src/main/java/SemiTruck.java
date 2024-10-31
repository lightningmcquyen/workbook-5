public class SemiTruck extends Vehicle {
    private boolean truckTrailer;

    public SemiTruck() {
        this.maxLoad = maxLoad;
        this.engineType = engineType;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}