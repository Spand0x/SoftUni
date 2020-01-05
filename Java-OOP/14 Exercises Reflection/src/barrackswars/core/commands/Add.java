package barrackswars.core.commands;

import barrackswars.interfaces.Repository;
import barrackswars.interfaces.Unit;
import barrackswars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = super.getUnitFactory().createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        super.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
