package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static motocrossWorldChampionship.common.ExceptionMessages.*;
import static motocrossWorldChampionship.common.OutputMessages.*;

public class ChampionshipControllerImpl implements ChampionshipController {
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Rider> riderRepository;
    private Repository<Race> raceRepository;

    public ChampionshipControllerImpl(Repository<Rider> riderRepository,Repository<Motorcycle> motorcycleRepository, Repository<Race> raceRepository) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {
        if (riderRepository.getByName(riderName) != null) {
            throw new IllegalArgumentException(String.format(RIDER_EXISTS,riderName));
        }
        Rider rider = new RiderImpl(riderName);
        riderRepository.add(rider);
        return String.format(RIDER_CREATED,riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        if(motorcycleRepository.getByName(model) !=null){
            throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS,model));
        }
        Motorcycle motorcycle = null;
        if (type.equals("Speed")) {
            motorcycle = new SpeedMotorcycle(model,horsePower);
        } else {
            motorcycle = new PowerMotorcycle(model,horsePower);
        }
        this.motorcycleRepository.add(motorcycle);
        return String.format(MOTORCYCLE_CREATED,motorcycle.getClass().getSimpleName(),model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        if(riderRepository.getByName(riderName) == null){
            throw new NullPointerException(String.format(RIDER_NOT_FOUND,riderName));
        }
        if(motorcycleRepository.getByName(motorcycleModel) == null){
            throw new NullPointerException(String.format(MOTORCYCLE_NOT_FOUND,motorcycleModel));
        }
        riderRepository.getByName(riderName).addMotorcycle(motorcycleRepository.getByName(motorcycleModel));
        return String.format(MOTORCYCLE_ADDED,riderName,motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND,raceName));
        }
        if(riderRepository.getByName(riderName) == null){
            throw new NullPointerException(String.format(RIDER_NOT_FOUND,riderName));
        }
        Rider rider = riderRepository.getByName(riderName);
        Race race = raceRepository.getByName(raceName);
        race.addRider(rider);
        return String.format(RIDER_ADDED,riderName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        if(raceRepository.getByName(raceName) == null){
            throw new NullPointerException(String.format(RACE_NOT_FOUND,raceName));
        }
        Race race = raceRepository.getByName(raceName);
        if(race.getRiders().size()<3){
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }

        int laps = race.getLaps();


        List<Rider> riders = new LinkedList<>(riderRepository.getAll()   );
        List<Rider> firstThreeRiders = riders.stream().sorted((r1, r2) -> Double.compare(r2.getMotorcycle().calculateRacePoints(laps), r1.getMotorcycle().calculateRacePoints(laps)))
                .limit(3)
                .collect(Collectors.toList());
        raceRepository.remove(race);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(RIDER_FIRST_POSITION,firstThreeRiders.get(0).getName(),raceName)).append(System.lineSeparator());
        sb.append(String.format(RIDER_SECOND_POSITION,firstThreeRiders.get(1).getName(),raceName)).append(System.lineSeparator());
        sb.append(String.format(RIDER_THIRD_POSITION,firstThreeRiders.get(2).getName(),raceName));
        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        if(raceRepository.getByName(name) != null){
            throw new IllegalArgumentException(String.format(RACE_EXISTS,name));
        }
        Race race = new RaceImpl(name,laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED,name);
    }
}
