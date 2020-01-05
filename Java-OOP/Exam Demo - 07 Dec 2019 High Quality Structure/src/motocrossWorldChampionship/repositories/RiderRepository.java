package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static motocrossWorldChampionship.common.ExceptionMessages.RIDER_EXISTS;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> models;

    public RiderRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Rider getByName(String name) {
        for (Rider rider : models) {
            if(rider.getName().equals(name)){
                return rider;
            }
        }
        return null;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Rider model) {
        if(this.models.contains(model)) {
            throw new IllegalArgumentException(String.format(RIDER_EXISTS, model.getName()));
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.models.remove(model);
    }
}
