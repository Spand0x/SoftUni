package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.*;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints; //todo: maybe deffense;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
       setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.healthPoints = healthPoints;
        this.targets = new ArrayList<>();
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException("Machine name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if(pilot == null){
            throw new NullPointerException("Pilot cannot be null.");
        }
        this.pilot = pilot;
    }

    @Override
    public double getAttackPoints() {
        return attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return defensePoints;
    }

    @Override
    public double getHealthPoints() {
        return healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        if(target == null || target.trim().isEmpty()){
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }
        this.targets.add(target);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(" *Health: ").append(this.healthPoints).append(System.lineSeparator());
       sb.append(" *Attack: ").append(this.attackPoints).append(System.lineSeparator());
       sb.append(" *Defense: ").append(this.defensePoints).append(System.lineSeparator());
       sb.append(" *Targets: ");
       if(targets.isEmpty()){
           sb.append("None");
       }else {
           sb.append(Arrays.toString(this.targets.toArray()).replaceAll("[\\[\\]]", ""));
       }
       return sb.toString();
    }
}
