package barrackswars.core.commands;

import barrackswars.interfaces.Repository;
import barrackswars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {

    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = super.getData()[1];
        try {
            super.getRepository().removeUnit(unitType);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
        return unitType + " retired!";
    }
}
