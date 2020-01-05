package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;
import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String,Pilot> pilots;
    private Map<String,Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
     this.pilotFactory = pilotFactory;
     this.machineFactory = machineFactory;
     this.pilots = pilots;
     this.machines = machines;

    }


    @Override
    public String hirePilot(String name) {
        Pilot pilot = pilotFactory.createPilot(name);
        if (!this.pilots.containsKey(name)) {
            this.pilots.put(name,pilot);
            return String.format(pilotHired,name);
        }
        return String.format(pilotExists,name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        Machine machine = this.machineFactory.createTank(name,attackPoints,defensePoints);
        if(!this.machines.containsKey(name)){
            this.machines.put(name,machine);
            return String.format(tankManufactured,name,attackPoints,defensePoints);
        }
        return String.format(machineExists,name);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        Machine machine = this.machineFactory.createFighter(name,attackPoints,defensePoints);
        if(!this.machines.containsKey(name)){
            this.machines.put(name,machine);
            return String.format(fighterManufactured,name,attackPoints,defensePoints);
        }
        return String.format(machineExists,name);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Pilot pilot = this.pilots.get(selectedPilotName);
        if(pilot == null){
            return String.format(pilotNotFound,selectedPilotName);
        }

        Machine machine = this.machines.get(selectedMachineName);
        if(machine == null){
            return String.format(machineNotFound,selectedMachineName);
        }

        if(machine.getPilot() != null){
            return String.format(machineHasPilotAlready,selectedMachineName);
        }

        pilot.addMachine(machine);
        machine.setPilot(pilot);
        return String.format(machineEngaged,selectedPilotName,selectedMachineName);

    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine attackingMachine = this.machines.get(attackingMachineName);
        if(attackingMachine == null){
            return String.format(machineNotFound,attackingMachineName);
        }

        Machine defendingMachine = this.machines.get(defendingMachineName);
        if(defendingMachine == null){
            return String.format(machineNotFound,defendingMachineName);
        }

        if(attackingMachine.getAttackPoints()>defendingMachine.getDefensePoints()){
            defendingMachine.setHealthPoints(defendingMachine.getHealthPoints()-(attackingMachine.getAttackPoints()-defendingMachine.getDefensePoints()));
            if(defendingMachine.getHealthPoints()<0){
                defendingMachine.setHealthPoints(0);
            }
        }

        attackingMachine.getTargets().add(defendingMachineName);
        return String.format(attackSuccessful,defendingMachineName,attackingMachineName,defendingMachine.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        Pilot pilot = this.pilots.get(pilotName);
        if(pilot == null){
            return String.format(pilotNotFound,pilotName);
        }
        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        Machine machine = this.machines.get(fighterName);

        if(machine == null){
            return String.format(machineNotFound,fighterName);
        }

        if(machine instanceof Fighter){
            ((Fighter) machine).toggleAggressiveMode();
            return String.format(fighterOperationSuccessful,fighterName);
        }
        return String.format(notSupportedOperation,fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        Machine machine = this.machines.get(tankName);
        if(machine == null){
            return String.format(machineNotFound,tankName);
        }
        if(machine instanceof Tank){
            ((Tank) machine).toggleDefenseMode();
            return String.format(tankOperationSuccessful,tankName);
        }
        return String.format(notSupportedOperation,tankName);
    }
}
