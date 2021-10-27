package Lab_9_1.TestRace;

import Lab_9_1.AbstractAnimal.AnimalTemplate;
import Lab_9_1.MyAnimal.Bird;
import Lab_9_1.MyAnimal.Elephant;
import Lab_9_1.MyAnimal.Horse;
import Lab_9_1.MyAnimal.Tiger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TestAnimalRace {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<String, List<AnimalTemplate>> animalMap = new HashMap<>();

        animalMap.put("Horse" , createListHorse());
        animalMap.put("Tiger" , createListTiger());
        animalMap.put("Elephant" , createListElephant());
        animalMap.put("Bird" , createListBird());

        RaceControl raceControl = new RaceControl(animalMap);

        System.out.println("THE AMAZING ANIMAL RACE GAME IS ABOUT TO BEGIN! GET READY");
        System.out.println("""
                WHICH ANIMAL WILL BE THE WINNER THIS YEAR?\s
                PLEASE ENTER YOUR PREDICTION:\s
                ONLY 3 SPECIES JOIN THE RACE (TIGER, HORSE, ELEPHANT)""");
        String winnerName = SCANNER.nextLine();

        System.out.println("PLEASE ENTER NUMBER OF ROUNDS: (at least 10 rounds)");
        int numOfRound;
        while (true) {
            numOfRound = SCANNER.nextInt();
            if (numOfRound >= 10) {
                break;
            }
            System.out.print("Please try again: ");
        }

        raceControl.startLapSimulator(numOfRound);

        if (winnerName.equalsIgnoreCase(raceControl.getFinalResult())) {
            System.out.println("Amazing good job bro. You are correct!");
            return;
        }
        System.out.println("Your guess is wrong!!!");
    }

    /* The 4 methods below are used to create data of 4 List<AnimalTemplate> */
    private static List<AnimalTemplate> createListBird() {
        List<AnimalTemplate> listBird = new ArrayList<>();
        AnimalTemplate firstBird = Bird.createBird("Eagle" , false);
        AnimalTemplate secondBird = Bird.createBird("Owl" , false);
        AnimalTemplate thirdBird = Bird.createBird("Falcon" , false);
        listBird.add(firstBird);
        listBird.add(secondBird);
        listBird.add(thirdBird);

        return listBird;
    }

    private static List<AnimalTemplate> createListHorse() {
        List<AnimalTemplate> listHorse = new ArrayList<>();
        AnimalTemplate firstHorse = Horse.createHorse("Zebra Horse" , true);
        AnimalTemplate secondHorse = Horse.createHorse("Ponies Horse" , true);
        AnimalTemplate thirdHorse = Horse.createHorse("Appaloosa Horse" , true);
        AnimalTemplate fourthHorse = Horse.createHorse("Morgan Horse" , true);
        AnimalTemplate fifthHorse = Horse.createHorse("Arabian Horse" , true);
        listHorse.add(firstHorse);
        listHorse.add(secondHorse);
        listHorse.add(thirdHorse);
        listHorse.add(fourthHorse);
        listHorse.add(fifthHorse);

        return listHorse;
    }

    private static List<AnimalTemplate> createListTiger() {
        List<AnimalTemplate> listTiger = new ArrayList<>();
        AnimalTemplate firstTiger = Tiger.createTiger("South China Tiger" , true);
        AnimalTemplate secondTiger = Tiger.createTiger("Indochinese Tiger" , true);
        AnimalTemplate thirdTiger = Tiger.createTiger("Siberian Tiger" , true);
        AnimalTemplate fourthTiger = Tiger.createTiger("Bengal Tiger" , true);
        AnimalTemplate fifthTiger = Tiger.createTiger("Malayan Tiger" , true);
        listTiger.add(firstTiger);
        listTiger.add(secondTiger);
        listTiger.add(thirdTiger);
        listTiger.add(fourthTiger);
        listTiger.add(fifthTiger);

        return listTiger;
    }

    private static List<AnimalTemplate> createListElephant() {
        List<AnimalTemplate> listElephant = new ArrayList<>();
        AnimalTemplate firstElephant = Elephant.createElephant("African Elephant" , true);
        AnimalTemplate secondElephant = Elephant.createElephant("Savannah Elephant" , true);
        AnimalTemplate thirdElephant = Elephant.createElephant("Indian Elephant" , true);
        AnimalTemplate fourthElephant = Elephant.createElephant("Asian Elephant" , true);
        AnimalTemplate fifthElephant = Elephant.createElephant("Forest Elephant" , true);
        listElephant.add(firstElephant);
        listElephant.add(secondElephant);
        listElephant.add(thirdElephant);
        listElephant.add(fourthElephant);
        listElephant.add(fifthElephant);

        return listElephant;
    }

}
