package barrackswars.core.factories;

import barrackswars.interfaces.Unit;
import barrackswars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barrackswars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
        // TODO: implement for problem 3
        Unit unit = null;
        try {
            Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            unit = (Unit) clazz.getConstructor().newInstance();
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return unit;
    }
}