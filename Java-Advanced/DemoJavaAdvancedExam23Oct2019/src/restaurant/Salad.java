package restaurant;

import java.util.LinkedList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories(){
        int sum = 0;
        for (Vegetable veg :
                products) {
            sum+=veg.getCalories();
        }
        return sum;
    }

    public int getProductCount(){
        return products.size();
    }

    public void add(Vegetable vegetable){
        this.products.add(vegetable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("* Salad %s is %d calories and have %d products:",
                this.getName(),
                this.getTotalCalories(),
                this.getProductCount()))
                .append(System.lineSeparator());

        for (Vegetable product : products) {
            sb.append(product.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
