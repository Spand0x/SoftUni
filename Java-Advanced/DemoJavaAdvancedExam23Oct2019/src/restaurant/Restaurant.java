package restaurant;

import java.util.LinkedList;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedList<>();
    }

    public void add(Salad salad){
        data.add(salad);
    }

    public boolean buy(String name){
        for (Salad salad :
                data) {
            if(salad.getName().equalsIgnoreCase(name)){
                data.remove(salad);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad(){
        int minCalories = Integer.MAX_VALUE;
        Salad minSalad = null;
        for (Salad salad :
                data) {
            if (minCalories > salad.getTotalCalories()){
                minCalories = salad.getTotalCalories();
                minSalad = salad;
            }
        }
        return minSalad;
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s have %d salads:",
                this.name,
                this.data.size()))
                .append(System.lineSeparator());

        for (Salad kvp : data) {
            sb.append(kvp).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
