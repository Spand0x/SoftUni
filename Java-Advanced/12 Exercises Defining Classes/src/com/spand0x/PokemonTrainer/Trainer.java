package com.spand0x.PokemonTrainer;

import java.util.LinkedList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemons = new LinkedList<>();

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemons.add(pokemon);
    }

    public void addBadge(){
        this.numberOfBadges+=1;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }
    public void removePokemon(Pokemon pokemon){
        this.pokemons.remove(pokemon);
    }

    public int getBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return name + " " + numberOfBadges + " " + pokemons.size();
    }
}
