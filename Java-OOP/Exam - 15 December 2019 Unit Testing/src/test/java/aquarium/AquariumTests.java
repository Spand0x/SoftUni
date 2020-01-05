package aquarium;

import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.MediaSize;

import static org.junit.Assert.*;

public class AquariumTests {
    private static final String AQUARIUM_NAME = "Aqua";
    private static final int CAPACITY = 5;
    private static final String FISH_NAME = "Nemo";
    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void createAquarium(){
        this.aquarium = new Aquarium(AQUARIUM_NAME,CAPACITY);
        this.fish = new Fish(FISH_NAME);
    }


    @Test (expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionWhenCapacityIsLessThanZero(){
        Aquarium aquarium = new Aquarium(AQUARIUM_NAME,-1);
    }

    //todo: checkCorrectMessage

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowExceptionWhenNameIsNull(){
        Aquarium aquarium = new Aquarium(null,CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowExceptionWhenNameIsEmpty(){
        Aquarium aquarium = new Aquarium("",CAPACITY);
    }

    @Test
    public void constructorShouldCreateNewAquarium(){
        Aquarium aquarium = new Aquarium(AQUARIUM_NAME,CAPACITY);
        int count = aquarium.getCount();
        assertEquals(0,count);
    }

    @Test
    public void getNameShouldReturnTheNameOfTheAquarium(){
        String name = this.aquarium.getName();
        assertEquals(AQUARIUM_NAME,name);
    }

    @Test
    public void getCapacityShouldReturnTheCapacityOfTheAquarium(){
        int capacity = this.aquarium.getCapacity();
        assertEquals(CAPACITY,capacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionWhenCapacityIsReached(){
        for (int i = 0; i < CAPACITY + 1; i++) {
            this.aquarium.add(this.fish);
        }
    }

    @Test
    public void addShouldAddFishToTheAquarium(){
        this.aquarium.add(fish);
        int count = this.aquarium.getCount();
        assertEquals(1,count);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeShouldThrowExceptionWhenFishIsNotPresented(){
        this.aquarium.add(fish);
        this.aquarium.remove("Gosho");
    }

    @Test
    public void removeShouldRemoveFishFromAquarium(){
        this.aquarium.add(this.fish);
        this.aquarium.remove(FISH_NAME);
        int count = this.aquarium.getCount();
        assertEquals(0,count);
    }

    @Test (expected = IllegalArgumentException.class)
    public void sellFishShouldThrowExceptionWhenFishIsNotPresented(){
        this.aquarium.add(this.fish);
        this.aquarium.sellFish("Gosho");
    }

    @Test
    public void sellFishShouldReturnTheSoldFish(){
        this.aquarium.add(this.fish);
        Fish soldFish = this.aquarium.sellFish(FISH_NAME);
        assertEquals(this.fish,soldFish);
    }

    @Test
    public void sellFishShouldSetFishToNotAvailable(){
        this.aquarium.add(this.fish);
        Fish soldFish = this.aquarium.sellFish(FISH_NAME);
        assertFalse(soldFish.isAvailable());
    }

    @Test
    public void reportShouldReturnCorrectMessageWhenEmpty(){
        String expected = "Fish available at " + AQUARIUM_NAME + ": ";
        String report = this.aquarium.report();
        assertEquals(expected,report);
    }

    @Test
    public void reportShouldReturnCorrectMessage(){
        this.aquarium.add(this.fish);
        String expected = "Fish available at " + AQUARIUM_NAME + ": " + FISH_NAME;
        String report = this.aquarium.report();
        assertEquals(expected,report);
    }
}

