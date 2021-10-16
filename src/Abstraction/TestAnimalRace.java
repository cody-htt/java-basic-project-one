package Abstraction;

import java.util.ArrayList;
import java.util.List;

public class TestAnimalRace {

    private final static List<Animal> ParticipatedAnimalList = new ArrayList<>();

    public static void main(String[] args) {

        Animal eagle = new FlyableAnimal.FlyableAnimalBuilder()
                .setName("The Eagle").setType("Bird").setMaxSpeed(500.00).setMinSpeed(300.00).checkFlyAbility(true)
                .build();

        Animal falcon = new FlyableAnimal.FlyableAnimalBuilder()
                .setName("The Falcon").setType("Bird").setMaxSpeed(500.00).setMinSpeed(300.00).checkFlyAbility(true)
                .build();

        Animal penguin = new FlyableAnimal.FlyableAnimalBuilder()
                .setName("The Penguin").setType("Bird").setMaxSpeed(50.00).setMinSpeed(15.00).checkFlyAbility(false)
                .build();

        Animal kakapo = new FlyableAnimal.FlyableAnimalBuilder()
                .setName("The kakapo").setType("Bird").setMaxSpeed(60.00).setMinSpeed(20.00).checkFlyAbility(false)
                .build();

        Animal tiger = new NonFlyAnimal.NonFlyAnimalBuilder()
                .setName("The Tiger").setType("Tiger").setMaxSpeed(100.00).setMinSpeed(35.00)
                .build();

        Animal horse = new NonFlyAnimal.NonFlyAnimalBuilder()
                .setName("The Horse").setType("Horse").setMaxSpeed(80.00).setMinSpeed(30.00)
                .build();

        Animal dog = new NonFlyAnimal.NonFlyAnimalBuilder()
                .setName("The Dog").setType("Dog").setMaxSpeed(65.00).setMinSpeed(30.00)
                .build();

        ParticipatedAnimalList.add(eagle);
        ParticipatedAnimalList.add(falcon);
        ParticipatedAnimalList.add(penguin);
        ParticipatedAnimalList.add(kakapo);
        ParticipatedAnimalList.add(tiger);
        ParticipatedAnimalList.add(horse);
        ParticipatedAnimalList.add(dog);

        RaceController raceController = new RaceController(ParticipatedAnimalList);
        Animal winner = raceController.getWinner();
        System.out.printf("%s is the winner with speed is %.2f\n", winner.toString(), winner.getSpeed());
        raceController.printRemovedAnimalList();
    }

}
