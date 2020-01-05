package barrackswars;


import barrackswars.core.Engine;
import barrackswars.core.factories.UnitFactoryImpl;
import barrackswars.data.UnitRepository;
import barrackswars.interfaces.Repository;
import barrackswars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
