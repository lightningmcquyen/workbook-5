public class Vehicle extends Asset {
    private final String makeModel;
    private final int year;
    private final int odometer;

    public Vehicle(String description, String dataAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dataAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public int getYear() {
        return year;
    }

    public int getOdometer() {
        return odometer;
    }

    @Override
    public double getValue() {
        double value = super.getValue(); // Start with the original cost

        // Calculate the vehicle's age
        int age = 2024 - year;

        // Adjust the value based on age
        if (age <= 3) {
            value *= (1 - 0.03 * age); // Reduce by 3% per year for 0-3 years old
        } else if (age <= 6) {
            value *= (1 - 0.06 * (age - 3)); // Reduce by 6% per year for 4-6 years old
        } else if (age <= 10) {
            value *= (1 - 0.08 * (age - 6)); // Reduce by 8% per year for 7-10 years old
        } else {
            value -= 1000; // Subtract $1000 for vehicles over 10 years old
        }

        // reduce final value by 25% if over 100K miles (unless Honda or Toyota)
        if (odometer > 100000 && !(makeModel.toLowerCase().contains("honda") || makeModel.toLowerCase().contains("toyota"))) {
            value *= 0.75; // Reduce final value by 25%
        }

        // value can't be negative
        return Math.max(value, 0);
    }

    @Override
    public String toString() {
        return super.toString() + ", Vehicle{" +
                "makeModel='" + makeModel + '\'' +
                ", year=" + year +
                ", odometer=" + odometer +
                '}';
    }
}