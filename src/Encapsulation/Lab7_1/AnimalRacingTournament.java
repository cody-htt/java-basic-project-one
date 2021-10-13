package Encapsulation.Lab7_1;

import java.util.List;

public class AnimalRacingTournament {

    public static Animal getTheWinner (List<Animal> animals) {
        Animal winner = null;

        for (Animal animal : animals) {
            if (!animal.isAllowToRace() && (animal.getName() == null || animal.getType() == null)) {
                System.out.println("The " + (animal.getType() != null ? animal.getType() : "animal").toUpperCase() +
                        " have the name " + (animal.getName() != null ? animal.getName() : "no name").toUpperCase() +
                        " is not allowed to join the race tournament");
            } else if (!animal.isAllowToRace()) {
                System.out.println("The " + animal.getType().toUpperCase() +
                        " have the name " + animal.getName().toUpperCase() +
                        " is not allowed to join the race tournament");
            } else {
                if (winner == null) {
                    winner = animal;
                } else {
                    if (winner.getSelectSpeed() < animal.getSelectSpeed()) {
                        winner = animal;
                    }
                }
            }
        }

        return winner;
    }

}
