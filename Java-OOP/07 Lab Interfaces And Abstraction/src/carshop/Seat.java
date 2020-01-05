package carshop;

import java.io.Serializable;

public class Seat extends CarImpl implements Sellable {
    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced,double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public int getHorsePower() {
        return super.getHorsePower();
    }

    @Override
    public String countryProduced() {
        return super.countryProduced();
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {

        return super.toString() + String.format("%s sells for %f",this.getModel(),this.price);
    }
}
