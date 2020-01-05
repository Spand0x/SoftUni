package vehiclesextension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    private static double AC_CONSUMPTION = 1.4;

    protected Bus(double fuelQuantity, double fuelConsumption,double tankSize) {
        super(fuelQuantity, fuelConsumption+AC_CONSUMPTION,tankSize);
    }


    String driveEmpty(double distance) {
        DecimalFormat format = new DecimalFormat("#.##");
        double emptyConsumption = super.getFuelConsumption()-AC_CONSUMPTION;
        if(emptyConsumption*distance<=super.getFuelQuantity()){
            super.setFuelQuantity(super.getFuelQuantity() - distance*emptyConsumption);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(distance));

        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }
}
