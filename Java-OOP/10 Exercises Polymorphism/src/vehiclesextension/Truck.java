package vehiclesextension;

public class Truck extends Vehicle {
    private static double AC_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumption,double tankSize) {
        super(fuelQuantity, fuelConsumption+AC_CONSUMPTION,tankSize);
    }


    @Override
    protected void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
