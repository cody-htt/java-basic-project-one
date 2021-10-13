package Encapsulation.Lab7_1;

import java.util.Arrays;

import static Encapsulation.Lab7_1.AnimalRacingTournament.getTheWinner;

public class TestAnimalRace {

    public static void main(String[] args) {

        Animal funnyHorse = new Animal.AnimalBuilder(null, "Funny Boy")
                .hasWings(false).isMoveByFeet(true).setMaxSpeed(80).setMinSpeed(45)
                .build();

        Animal lazyHorse = new Animal.AnimalBuilder("Horse", "Lazy Boy")
                .hasWings(false).isMoveByFeet(true).setMaxSpeed(60).setMinSpeed(20)
                .build();

        Animal hungryTiger = new Animal.AnimalBuilder("Tiger", "Meat Hunter")
                .hasWings(false).isMoveByFeet(true).setMaxSpeed(95).setMinSpeed(45)
                .build();

        Animal babyTiger = new Animal.AnimalBuilder("Tiger", "Teenager")
                .hasWings(false).isMoveByFeet(true).setMaxSpeed(75).setMinSpeed(50)
                .build();

        Animal oldDog = new Animal.AnimalBuilder("Dog", "The Elder")
                .hasWings(false).isMoveByFeet(true).setMaxSpeed(70).setMinSpeed(30)
                .build();

        Animal youngEagle = new Animal.AnimalBuilder("Bird (Eagle)", "The Eagle")
                .hasWings(true).isMoveByFeet(true).setMaxSpeed(500).setMinSpeed(300)
                .build();

        Animal motherGoose = new Animal.AnimalBuilder("Bird (Goose)", "The Carrier")
                .hasWings(true).isMoveByFeet(true).setMaxSpeed(500).setMinSpeed(300)
                .build();

        Animal brotherFalcon = new Animal.AnimalBuilder("Bird (Falcon)", "The Killer")
                .hasWings(true).isMoveByFeet(true).setMaxSpeed(500).setMinSpeed(300)
                .build();

        Animal winner = getTheWinner(Arrays.asList(
                funnyHorse, lazyHorse, hungryTiger, babyTiger, oldDog, youngEagle, motherGoose, brotherFalcon));

        System.out.println("The winner is " + winner.getName().toUpperCase() +
                " which is a " + winner.getType().toUpperCase() +
                ", with the highest speed: " + winner.getSelectSpeed());
    }

}
