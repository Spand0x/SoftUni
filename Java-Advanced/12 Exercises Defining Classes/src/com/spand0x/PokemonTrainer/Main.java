package com.spand0x.PokemonTrainer;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!"Tournament".equalsIgnoreCase(input[0])) {
            String trainer = input[0];
            String pokemonName = input[1];
            String pokeElement = input[2];
            int pokeHealth = Integer.parseInt(input[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokeElement, pokeHealth);
            if (!trainers.containsKey(trainer)) {
                trainers.putIfAbsent(trainer, new Trainer(trainer, pokemon));
            } else {
                trainers.get(trainer).addPokemon(pokemon);
            }
            input = scanner.nextLine().split("\\s+");
        }
        String element = scanner.nextLine();
        while (!"End".equalsIgnoreCase(element)) {
            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                List<Pokemon> pokemons = trainer.getValue().getPokemons();
                String finalElement = element;
                boolean containsElement = pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equalsIgnoreCase(finalElement));
                if (containsElement) {
                    trainer.getValue().addBadge();
                } else {
                    pokemons.forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    for (Pokemon pokemon : pokemons) {
                        if (pokemon.getHealth() <= 0) {
                            trainer.getValue().removePokemon(pokemon);
                        }
                    }
                }
            }
            element = scanner.nextLine();
        }

        List<Trainer> trainerList = new LinkedList<>(trainers.values());
        trainerList.stream().sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(t -> System.out.println(t.toString()));


        System.out.println();
    }
}
