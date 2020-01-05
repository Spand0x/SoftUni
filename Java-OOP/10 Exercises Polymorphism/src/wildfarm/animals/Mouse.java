package wildfarm.animals;

import wildfarm.food.Food;
import wildfarm.food.Vegetable;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight,  livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Vegetable)){
            super.setFoodEaten(new Vegetable(0));
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.setFoodEaten(food);
    }
}
