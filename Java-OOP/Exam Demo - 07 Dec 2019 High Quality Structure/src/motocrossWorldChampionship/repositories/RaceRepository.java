package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static motocrossWorldChampionship.common.ExceptionMessages.RACE_EXISTS;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> models;

    public RaceRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Race getByName(String name) {
        for (Race race : models) {
            if(race.getName().equals(name)){
                return race;
            }
        }
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Race model) {
        if (this.models.contains(model)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, model.getName()));
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return models.remove(model);
    }
}
