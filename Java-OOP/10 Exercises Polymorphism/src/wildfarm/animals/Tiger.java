package wildfarm.animals;

import wildfarm.food.Food;
import wildfarm.food.Meat;
import wildfarm.food.Vegetable;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)){
            super.setFoodEaten(new Meat(0));
            throw new IllegalArgumentException(this.getClass().getSimpleName() + "s are not eating that type of food!");

        }
        super.setFoodEaten(food);
    }
}
