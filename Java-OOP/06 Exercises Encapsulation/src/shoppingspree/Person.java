package shoppingspree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void buyProduct(Product product){
        double cost = product.getCost();
        if(cost>this.money){
            throw new IllegalArgumentException(this.getName() + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.money-=cost;
    }

    private void setMoney(double money) {
        if(money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.products.isEmpty()){
            sb.append(this.name).append(" - Nothing bought").append(System.lineSeparator());
        }else{
            sb.append(this.name).append(" - ");
            sb.append(Arrays.toString(products.toArray()).replaceAll("[\\[\\]]",""));
        }
        return sb.toString();
    }
}
