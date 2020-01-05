package wildfarm.animals;

import wildfarm.food.Food;
import wildfarm.food.Vegetable;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }


    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",super.getAnimalType(),super.getAnimalName(),format.format(super.getAnimalWeight()),this.livingRegion,super.getFoodEaten());
    }
}
