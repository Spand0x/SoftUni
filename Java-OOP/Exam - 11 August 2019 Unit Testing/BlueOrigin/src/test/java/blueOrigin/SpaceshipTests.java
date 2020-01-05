package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    private static final String SPACESHIP_NAME = "Apollo";
    private static final int SPACESHIP_CAPACITY = 5;
    private static final String ASTRONAUT_NAME = "Gosho";
    private static final double ASTRONAUT_OXYGEN = 20.0;
    private Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void createSpaceshipAndAstronaut(){
        this.spaceship = new Spaceship(SPACESHIP_NAME,SPACESHIP_CAPACITY);
        this.astronaut = new Astronaut(ASTRONAUT_NAME,ASTRONAUT_OXYGEN);
    }



    @Test (expected = NullPointerException.class)
    public void createSpaceshipShouldThrowExceptionWhenNameIsNull(){
        Spaceship spaceship = new Spaceship(null,1);
    }

    @Test
    public void creatingSpaceshipShouldReturnCorrectMessageWhenNameIsNull(){
        String message = "";
        try {
            Spaceship spaceship = new Spaceship(null,1);
        }catch (NullPointerException e){
            message = e.getMessage();
        }
        assertEquals("Invalid spaceship name!",message);
    }

    @Test (expected = NullPointerException.class)
    public void createSpaceshipShouldThrowExceptionWhenNameIsEmpty(){
        Spaceship spaceship = new Spaceship("",1);
    }

    @Test
    public void creatingSpaceshipShouldReturnCorrectMessageWhenNameIsEmpty(){
        String message = "";
        try {
            Spaceship spaceship = new Spaceship("",1);
        }catch (NullPointerException e){
            message = e.getMessage();
        }
        assertEquals("Invalid spaceship name!",message);
    }

    @Test (expected = IllegalArgumentException.class)
    public void creatingSpaceshipShouldThrowExceptionWhenCapacityIsLessThanZero(){
        Spaceship spaceship = new Spaceship(SPACESHIP_NAME,-1);
    }

    @Test
    public void creatingSpaceshipShouldReturnCorrectMessageWhenCapacityIsLessThanZero(){
        String message = "";
        try {
            Spaceship spaceship = new Spaceship(SPACESHIP_NAME,-1);
        }catch (IllegalArgumentException e){
            message = e.getMessage();
        }
        assertEquals("Invalid capacity!",message);
    }

    @Test
    public void getCountShouldReturnEmptyCollectionWhenCreatingNewSpaceship(){
        Spaceship spaceship = new Spaceship(SPACESHIP_NAME,SPACESHIP_CAPACITY);
        int count = spaceship.getCount();
        assertEquals(0,count);
    }

    @Test
    public void getCountShouldReturnCountOfAstronautsInSpaceship(){
        this.spaceship.add(astronaut);
        int count = this.spaceship.getCount();
        assertEquals(1,count);
    }

    @Test
    public void getNameShouldReturnTheNameOfTheSpaceship(){
        String name = this.spaceship.getName();
        assertEquals(SPACESHIP_NAME,name);
    }

    @Test
    public void getCapacityShouldReturnTheCapacityOfTheSpaceship(){
        int capacity = this.spaceship.getCapacity();
        assertEquals(SPACESHIP_CAPACITY,capacity);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionWhenAddingAstronautToFullCapacitySpaceship(){
        Spaceship spaceship = new Spaceship(SPACESHIP_NAME,1    );
        spaceship.add(this.astronaut);
        spaceship.add(new Astronaut("Pesho",10));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionWhenAddingTheSameAstronautTwice(){
        this.spaceship.add(this.astronaut);
        this.spaceship.add(this.astronaut);
    }

    @Test
    public void addShouldAddAstronautToTheSpaceship(){
        this.spaceship.add(astronaut);
        int count = spaceship.getCount();
        assertEquals(1,count);
    }

    @Test
    public void removeShouldReturnFalseWhenAstronautDoesNotExist(){
        boolean isRemoved = this.spaceship.remove(ASTRONAUT_NAME);
        assertFalse(isRemoved);
    }

    @Test
    public void removeShouldReturnTrueWhenRemovingAstronaut(){
        this.spaceship.add(astronaut);
        boolean isRemoved = this.spaceship.remove(astronaut.getName());
        assertTrue(isRemoved);
    }
}
