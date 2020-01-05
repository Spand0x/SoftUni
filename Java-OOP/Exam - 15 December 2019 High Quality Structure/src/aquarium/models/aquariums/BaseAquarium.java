package aquarium.models.aquariums;

import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.*;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish currentFish : fish) {
            currentFish.eat();
        }
    }


//    @Override
//    public String getInfo() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(this.name).append(" (").append(getClass().getSimpleName()).append("):").append(System.lineSeparator());
//        if(this.fish.isEmpty()){
//            sb.append("Fish: none").append(System.lineSeparator());
//        }else {
//            List<String> fishName = new LinkedList<>();
//            for (Fish fish1 : fish) {
//                fishName.add(fish1.getName());
//            }
//            sb.append("Fish: ").append(Arrays.toString(fishName.toArray()).replaceAll("[\\[\\]]", "")).append(System.lineSeparator());
//        }
//        sb.append("Decorations: ").append(decorations.size()).append(System.lineSeparator());
//        sb.append("Comfort: ").append(this.calculateComfort());
//        return sb.toString();
//    }


    @Override
    public String getInfo() {
        String fishString = "";
        if(this.fish.size() !=0){
            List<String> fishNames = new LinkedList<>();
            for (Fish currentFish : fish) {
                fishNames.add(currentFish.getName());
            }
            fishString = Arrays.toString(fishNames.toArray()).replaceAll("[\\[\\]]","");
        }
        String message = String.format("%s (%s):\n" +
                        "Fish: %s\n" +
                        "Decorations: %d\n" +
                        "Comfort: %d",
                this.name,
                this.getClass().getSimpleName(),
                fishString.equals("")?"none":fishString,
                this.decorations.size(),
                this.calculateComfort());
        return message;
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish; //todo: maybe unmodifiable
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations; //todo: maybe unmodifiable
    }
}
