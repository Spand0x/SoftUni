package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_EXISTS;

public class MotorcycleRepository implements Repository<Motorcycle> {
    private Collection<Motorcycle> models;

    public MotorcycleRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        for (Motorcycle motorcycle : models) {
            if(motorcycle.getModel().equals(name)){
                return motorcycle;
            }
        }
        return null;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Motorcycle model) {
        if (this.models.contains(model)) {
            throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, model.getModel()));
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.models.remove(model);
    }
}
