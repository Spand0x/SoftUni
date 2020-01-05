package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int planetsExplored;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
        this.planetsExplored = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        this.planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitableAstronauts = new ArrayList<>();
        for (Astronaut currentAstronaut : this.astronautRepository.getModels()) {
            if (currentAstronaut.getOxygen() > 60) {
                suitableAstronauts.add(currentAstronaut);
            }
        }
        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = planetRepository.findByName(planetName);
        this.mission.explore(planet, suitableAstronauts);

        int deadAstronauts = 0;
        for (Astronaut suitableAstronaut : suitableAstronauts) {
            if (suitableAstronaut.getOxygen() == 0) {
                deadAstronauts++;
            }
        }
        this.planetsExplored++;
        return String.format(PLANET_EXPLORED,planetName,deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED,this.planetsExplored)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO);
        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            sb.append(System.lineSeparator()).append(String.format(REPORT_ASTRONAUT_NAME,astronaut.getName())).append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN,astronaut.getOxygen())).append(System.lineSeparator());
            if(astronaut.getBag().getItems().isEmpty()){
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,"none"));
            }else {
                String bagItems = Arrays.toString(astronaut.getBag().getItems().toArray()).replaceAll("[\\[\\]]","");
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,bagItems));
            }
        }
        return sb.toString();
    }
}
