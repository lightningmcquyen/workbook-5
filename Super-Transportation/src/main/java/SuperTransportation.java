public class SuperTransportation {
    public static void main(String[] args) {

        Moped slowRide = new Moped();
        slowRide.setModel("Ruckus");
        slowRide.setColor("Red");
        slowRide.setFuelCapacity(2);
        System.out.println("When I'm in the mood for a cruise, I take my " + slowRide.getModel()
                + " (bright cherry " + slowRide.getColor()
                + " and only has fuel capacity of " + slowRide.getFuelCapacity()+ " gallons.");


        Car myCar = new Car();
        myCar.setModel("IS 250");
        myCar.setColor("Black");
        myCar.setMake("Lexus");
        myCar.setNumberOfPassengers(5);
        System.out.println("My car is a " + myCar.getColor() + " " + myCar.getMake() + " " + myCar.getModel()
                + " and it seats about " + myCar.getNumberOfPassengers() + " passengers including myself.");


        SemiTruck mySemi = new SemiTruck();
        mySemi.setColor("white");
        mySemi.setNumberOfPassengers(40);
        System.out.println("My semi-truck is " + mySemi.getColor()
        + " and it can seat about " + mySemi.getNumberOfPassengers() + " passengers comfortably.");


        HoverCraft myHovercraft = new HoverCraft();
        myHovercraft.setColor("silver");
        myHovercraft.setAllTerrain(true);
        myHovercraft.setMaxSpeed(70);
        System.out.println("My " + myHovercraft.getColor() + " hovercraft has a max speed of "
                + myHovercraft.getMaxSpeed() + " mph. "
                + "Seeing as it's a hovercraft...is it true that it can drive on all terrains? It is " + myHovercraft.isAllTerrain() + ".");

    }
}
