package wildfarm.animals;

import wildfarm.food.Food;
import wildfarm.food.Vegetable;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Vegetable)){
            super.setFoodEaten(new Vegetable(0));
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(food);
    }



}
