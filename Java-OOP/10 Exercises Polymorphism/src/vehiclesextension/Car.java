package vehiclesextension;

public class Car extends Vehicle {

    private static double AC_CONSUMPTION = 0.9;
    
    
    
    public Car(double fuelQuantity, double fuelConsumption,double tankSize) {
        super(fuelQuantity, fuelConsumption+AC_CONSUMPTION,tankSize);
    }

}
