package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private Collection<Machine> machines;

    public PilotImpl(String name) {
        setName(name);
        this.machines = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pilot name cannot be null or empty string.");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addMachine(Machine machine) {
        if(machine == null){
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }
        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        List<Machine> returnMachines = new ArrayList<>(this.machines);
        return Collections.unmodifiableList(returnMachines);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ").append(this.machines.size()).append(" machines");
        if(!machines.isEmpty()){
            sb.append(System.lineSeparator());
        }
        for (Machine machine : machines) {
            sb.append(machine.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
