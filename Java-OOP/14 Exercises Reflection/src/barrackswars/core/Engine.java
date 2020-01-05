package barrackswars.core;

import barrackswars.interfaces.Executable;
import barrackswars.interfaces.Repository;
import barrackswars.interfaces.Unit;
import barrackswars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMANDS_PACKAGE_NAME = "barrackswars.core.commands." ;
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException {
        String className = data[0].substring(0,1).toUpperCase() + data[0].substring(1);
        Class clazz = Class.forName(COMMANDS_PACKAGE_NAME + className);
        Constructor constructor = clazz.getDeclaredConstructor(String[].class,Repository.class,UnitFactory.class);
        Executable executable = (Executable) constructor.newInstance(data,this.repository,this.unitFactory);

        return executable.execute();
    }
}
