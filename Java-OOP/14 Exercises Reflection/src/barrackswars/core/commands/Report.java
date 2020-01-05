package barrackswars.core.commands;

import barrackswars.interfaces.Repository;
import barrackswars.interfaces.UnitFactory;

import java.lang.reflect.Executable;

public class Report extends Command {

    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return super.getRepository().getStatistics();
    }
}
