package wildfarm.animals;

import wildfarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion,String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food);
    }


    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",super.getAnimalType(),super.getAnimalName(),this.breed, format.format(super.getAnimalWeight())
                ,super.getLivingRegion(),super.getFoodEaten());
    }
}
