package motocrossWorldChampionship.entities;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SpeedMotorcycle extends MotorcycleImpl {
    private static final double DEFAULT_CUBIC_CENTIMETERS = 125;
    private static final int MINIMUM_HORSEPOWER = 50;
    private static final int MAXIMUM_HORSEPOWER = 69;


    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS);
        setHorsePower(horsePower);
    }

    protected void setHorsePower(int horsePower){
        if(horsePower<MINIMUM_HORSEPOWER || horsePower>MAXIMUM_HORSEPOWER){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
