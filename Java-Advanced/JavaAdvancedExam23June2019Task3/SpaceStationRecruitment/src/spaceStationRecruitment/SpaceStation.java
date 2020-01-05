package spaceStationRecruitment;


import java.util.*;

public class SpaceStation {
    private List<Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount(){
        return data.size();
    }
    public void add(Astronaut astronaut){
        if(data.size()<capacity) {
            data.add(astronaut);
        }
    }
    public boolean remove(String name){
        for (Astronaut astronaut :
                data) {
            if (astronaut.getName().equalsIgnoreCase(name)){
                data.remove(astronaut);
                return true;
            }
        }
        return false;
    }
    public Astronaut getOldestAstronaut(){
        return data.stream().min(Comparator.comparingInt(Astronaut::getAge)).get();
    }

    public Astronaut getAstronaut(String name){
        Astronaut current = null;
        for (Astronaut astronaut :
                data) {
            if (astronaut.getName().equalsIgnoreCase(name)){
                current = astronaut;
            }
        }
        return current;
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:", this.name)).append(System.lineSeparator());
        for (Astronaut astronaut :
                this.data) {
            sb.append(astronaut.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
