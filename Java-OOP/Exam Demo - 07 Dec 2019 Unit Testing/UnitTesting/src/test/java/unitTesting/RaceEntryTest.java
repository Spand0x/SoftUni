package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class RaceEntryTest {

    private RaceEntry raceEntry;
    private UnitMotorcycle unitMotorcycle;
    private UnitRider unitRider;
    private static final String DEFAULT_MODEL = "Audi";
    private static final int DEFAULT_HORSEPOWER = 40;
    private static final double DEFAULT_CUBIC_CENTIMETERS = 200.0;
    private static final String DEFAULT_RIDER_NAME = "Gosho";

    @Before
    public void createRace() {
        this.raceEntry = new RaceEntry();
        this.unitMotorcycle = new UnitMotorcycle(DEFAULT_MODEL, DEFAULT_HORSEPOWER, DEFAULT_CUBIC_CENTIMETERS);
        this.unitRider = new UnitRider(DEFAULT_RIDER_NAME, unitMotorcycle);
    }

    @Test
    public void getRidersShouldReturnEmptyCollectionWhenInit() {
        RaceEntry raceEntry = new RaceEntry();
        Collection<UnitRider> riders = raceEntry.getRiders();
        assertTrue(riders.isEmpty());
    }

    @Test
    public void getRidersShouldReturnCollectionWithRiders() {
        this.raceEntry.addRider(this.unitRider);
        Collection<UnitRider> riders = this.raceEntry.getRiders();
        assertEquals(1, riders.size());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getRiderShouldReturnUnmodifiableCollection(){
        this.raceEntry.getRiders().clear();
    }

    @Test(expected = NullPointerException.class)
    public void addRiderShouldThrowExceptionWhenNullIsGiven() {
        this.raceEntry.addRider(null);
    }

    @Test
    public void addRiderShouldReturnCorrectMessageWhenNullIsGiven() {
        String expected = "Rider cannot be null.";
        String actual = "";
        try {
            this.raceEntry.addRider(null);

        }catch (NullPointerException e){
            actual = e.getMessage();
        }
        assertEquals(expected,actual);
    }

    @Test
    public void addRiderShouldAddRiderToCollection() {
        String message = this.raceEntry.addRider(this.unitRider);
        String expected = String.format("Rider %s added in race.", DEFAULT_RIDER_NAME);
        assertEquals(expected, message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderShouldThrowExceptionWhenAddingTheSameRiderTwice() {
        this.raceEntry.addRider(this.unitRider);
        this.raceEntry.addRider(this.unitRider);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldThrowExceptionWhenCollectionSizeIsLessThanTwo() {
        this.raceEntry.addRider(this.unitRider);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAverageHorsePowerShouldReturnAverageHorsePowerOfAllRiders() {
        this.raceEntry.addRider(this.unitRider);

        UnitRider newCurrentRider = new UnitRider("Pesho", this.unitMotorcycle);
        this.raceEntry.addRider(newCurrentRider);

        double expectedAverage = 40.0;

        double averageHorsePower = this.raceEntry.calculateAverageHorsePower();
        assertEquals(expectedAverage, averageHorsePower, 0);
    }

    @Test
    public void getRidersShouldBeReturnCollectionWithCorrectValues(){


        UnitRider secondTest = new UnitRider("SecondTest", this.unitMotorcycle);
        UnitRider thirdTest = new UnitRider("ThirdTest", this.unitMotorcycle);

        Collection<UnitRider> expected = new ArrayList<>();

        expected.add(this.unitRider);
        expected.add(secondTest);
        expected.add(thirdTest);

        this.raceEntry.addRider(this.unitRider);
        this.raceEntry.addRider(secondTest);
        this.raceEntry.addRider(thirdTest);

        Collection<UnitRider> actual = new ArrayList<>(this.raceEntry.getRiders());

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected.size(),actual.size());
    }



    @Test
    public void addRiderShouldThrowExceptionIfRiderAreExistWithCorrectMessage(){
        final String expected = "Rider "+DEFAULT_RIDER_NAME+" is already added";

        String actual = "";

        try {

            this.raceEntry.addRider(this.unitRider);
            this.raceEntry.addRider(this.unitRider);

        }catch (IllegalArgumentException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(expected,actual);

    }



    @Test
    public void calculateAverageHorsePowerShouldThrowExceptionIfRidersLessExpectedCountWithCorrectMessage(){
        this.raceEntry.addRider(this.unitRider);

        final String expected = "The race cannot start with less than 2 participants.";

        String actual = "";

        try {
            this.raceEntry.calculateAverageHorsePower();
        }catch (IllegalArgumentException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(expected,actual);
    }

}
