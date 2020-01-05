package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

import static motocrossWorldChampionship.common.ExceptionMessages.*;

public class RiderImpl implements Rider {
    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    public RiderImpl(String name) {
        setName(name);
        this.canParticipate = false;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty() || name.length()<5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,name,5));
        }
        this.name = name;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if(motorcycle == null){
            throw new NullPointerException(MOTORCYCLE_INVALID);
        }
        this.motorcycle = motorcycle;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    public boolean getCanParticipate() {
        return canParticipate;
    }
}
