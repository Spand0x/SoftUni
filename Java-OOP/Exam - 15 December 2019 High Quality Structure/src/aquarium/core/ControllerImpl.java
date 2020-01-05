package aquarium.core;

import aquarium.models.aquariums.Aquarium;
import aquarium.models.aquariums.FreshwaterAquarium;
import aquarium.models.aquariums.SaltwaterAquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;
import aquarium.models.fish.Fish;
import aquarium.models.fish.FreshwaterFish;
import aquarium.models.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository decorations; //todo maybe only repository
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;
        if(aquariumType.equals("FreshwaterAquarium")){
            aquarium = new FreshwaterAquarium(aquariumName);
        }else if(aquariumType.equals("SaltwaterAquarium")){
            aquarium = new SaltwaterAquarium(aquariumName);
        }else {
            throw new IllegalArgumentException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE,aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;
        if(type.equals("Ornament")){
            decoration = new Ornament();
        }else if(type.equals("Plant")){
            decoration = new Plant();
        }else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE,type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration neededDecoration = decorations.findByType(decorationType);
        if(neededDecoration == null){
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND,decorationType));
        }
        Aquarium neededAquarium = null;
        for (Aquarium aquarium : aquariums) {
            if(aquarium.getName().equals(aquariumName)){
                neededAquarium = aquarium;
            }
        }
        neededAquarium.addDecoration(neededDecoration);
        this.decorations.remove(neededDecoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM,decorationType,aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = null;
        Aquarium aquarium = null;
        for (Aquarium currentAquarium : aquariums) {
            if(currentAquarium.getName().equals(aquariumName)){
                aquarium = currentAquarium;
                break;
            }
        }

        if(fishType.equals("FreshwaterFish")){
            fish = new FreshwaterFish(fishName,fishSpecies,price);
            if(aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")){
                return WATER_NOT_SUITABLE;
            }

        }else if(fishType.equals("SaltwaterFish")){
            fish = new SaltwaterFish(fishName,fishSpecies,price);
            if(aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")){
                return WATER_NOT_SUITABLE;
            }
        }else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType,aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium currentAquarium : aquariums) {
            if(currentAquarium.getName().equals(aquariumName)){
                aquarium = currentAquarium;
                break;
            }
        }
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium currentAquarium : aquariums) {
            if(currentAquarium.getName().equals(aquariumName)){
                aquarium = currentAquarium;
            }
        }
        double value = 0;
        value = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        value += aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(VALUE_AQUARIUM,aquariumName,value);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int size = aquariums.size();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo());
            count++;
            if(count != size) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
