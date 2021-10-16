package Abstraction;

import java.util.ArrayList;
import java.util.List;

public class RaceController {

    private final List<Animal> animalList;

    public RaceController(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public Animal getWinner() {
        List<Animal> filterredAnimal = filterListAnimal();
        Animal winner = null;
        for (Animal animal : filterredAnimal) {
            if (winner == null) {
                winner = animal;
            } else {
                if (winner.getSpeed() < animal.getSpeed()) {
                    winner = animal;
                }
            }
        }
        return winner;
    }

    private List<Animal> filterListAnimal () {
        List<Animal> filterredAnimal = new ArrayList<>();
        for (Animal nonFlyAnimal : animalList) {
            if (!nonFlyAnimal.isFlyable()) {
                filterredAnimal.add(nonFlyAnimal);
            }
        }
        return filterredAnimal;
    }

    public void printRemovedAnimalList() {
        List<Animal> removedAnimalList = removedAnimal();
        for (Animal flyableAnimal : removedAnimalList) {
            System.out.println(flyableAnimal + " is not allowed to join the race");
        }
    }

    private List<Animal> removedAnimal () {
        List<Animal> removedAnimalList = new ArrayList<>();
        for (Animal flyableAnimal : animalList) {
            if (flyableAnimal.isFlyable()) {
                removedAnimalList.add(flyableAnimal);
            }
        }
        return removedAnimalList;
    }

}
