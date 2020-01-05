package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SoftParkTest {

    private static final String[] PARKING_SPOTS = {
            "A1",
            "A2",
            "A3",
            "A4",
            "B1",
            "B2",
            "B3",
            "B4",
            "C1",
            "C2",
            "C3",
            "C4"};

    private SoftPark softPark;
    private Car car;
    private static final String DEFAULT_REGISTRATION = "CA0000A";
    private static final String DEFAULT_MAKE = "AUDI";


    @Before
    public void createParkingAndCar(){
        softPark = new SoftPark();
        this.car = new Car(DEFAULT_MAKE,DEFAULT_REGISTRATION);
    }


    @Test
    public void constructorShouldCreateEmptyParkingSpots(){
        SoftPark softPark = new SoftPark();
        Map<String, Car> parking = softPark.getParking();
        Map<String, Car> testParking = new HashMap<>();
        for (String parkingSpot : PARKING_SPOTS) {
            testParking.put(parkingSpot,null);
        }
        Assert.assertEquals(testParking,parking);
    }

    @Test
    public void getParkingShouldReturnCollectionWithNull(){
        SoftPark softPark = new SoftPark();
        Map<String, Car> parking = softPark.getParking();
        Map<String, Car> testParking = new HashMap<>();
        for (String parkingSpot : PARKING_SPOTS) {
            testParking.put(parkingSpot,null);
        }
        Assert.assertEquals(testParking,parking);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionWhenInvalidSpotIsGiven(){
        this.softPark.parkCar("Z1",this.car);
    }

    @Test
    public void parkCarShouldParkCarAtSpot(){
        String parkedCar = this.softPark.parkCar("A1", this.car);
        String expected = String.format("Car:%s parked successfully!",this.car.getRegistrationNumber());
        Assert.assertEquals(expected,parkedCar);
    }

    @Test (expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionWhenParkingCarOnTakenSpot(){
        this.softPark.parkCar("A1",this.car);
        this.softPark.parkCar("A1",this.car);
    }

    @Test (expected = IllegalStateException.class)
    public void parkCarShouldThrowExceptionWhenCarAlreadyExists(){
        this.softPark.parkCar("A1",this.car);
        this.softPark.parkCar("B1",this.car);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionWhenInvalidSpotIsGiven(){
        this.softPark.removeCar("Z1",this.car);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionWhenRemovingCarFromDifferentSpot(){
        this.softPark.removeCar("A1",this.car);
    }

    @Test
    public void removeCarShouldRemoveCarFromGivenSpot(){
        this.softPark.parkCar("A1",this.car);
        String removedSpot = this.softPark.removeCar("A1", this.car);
        String expected = String.format("Remove car:%s successfully!",this.car.getRegistrationNumber());
        Assert.assertEquals(expected,removedSpot);
    }
}