package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            List<String> items = new ArrayList<>(planet.getItems());
            for (String item : items) {
                if (astronaut.canBreath()) {
                    astronaut.getBag().getItems().add(item);
                    planet.getItems().remove(item);
                    astronaut.breath();
                }
            }
        }
    }
}
