package com.spand0x.Google;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList = new LinkedList<>();
    private List<Parent> parentList = new LinkedList<>();
    private List<Children> childrenList = new LinkedList<>();
    private Car car;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public void addParent(Parent parent) {
        parentList.add(parent);
    }

    public void addChild(Children children) {
        childrenList.add(children);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.00");

        String print = name +
                "\nCompany: \n";
        if(company != null){
            print +=this.company.getName() + " " + this.company.getDepartment() + " " + formatter.format(this.company.getSalary()) + "\n";
        }
        print += "Car: \n";
        if(car != null){
            print += car.getModel() + " " + car.getSpeed() + "\n";
        }
        print+="Pokemon: \n";
        for (Pokemon pokemon :
                pokemonList) {
            print += pokemon.toString();
        }
        print += "Parents: \n";
        for(Parent parent : parentList)  {
            print += parent.toString();
        }
        print += "Children: \n";
        for (Children child :
                childrenList) {
            print += child.toString();
        }
        return print;
    }
}
