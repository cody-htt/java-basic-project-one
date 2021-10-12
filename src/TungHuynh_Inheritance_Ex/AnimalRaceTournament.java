package TungHuynh_Inheritance_Ex;

import java.security.SecureRandom;

public class AnimalRaceTournament {

    public static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static void startTheRace() {

        //Initiate Horse object
        Horse horse = new Horse();
        horse.setHorseSpeed(SECURE_RANDOM);
        int horseSpeed = horse.getSpeed();
        System.out.println("First competitor is " + Horse.getDefaultName() + " and its speed is " + horse.getSpeed());

        //Initiate Tiger object
        Tiger tiger = new Tiger();
        tiger.setTigerSpeed(SECURE_RANDOM);
        int tigerSpeed = tiger.getSpeed();
        System.out.println("Second competitor is " + Tiger.getDefaultName() + " and its speed is " + tiger.getSpeed());

        ////Initiate Dog object
        Dog dog = new Dog();
        dog.setDogSpeed(SECURE_RANDOM);
        int dogSpeed = dog.getSpeed();
        System.out.println("Third competitor is " + Dog.getDefaultName() + " and its speed is " + dog.getSpeed());

        //Start the race
        if (horseSpeed > tigerSpeed && horseSpeed > dogSpeed) {
            horse.claimWinner(horse);
        } else if (tigerSpeed > horseSpeed && tigerSpeed > dogSpeed) {
            tiger.claimWinner(tiger);
        } else {
            dog.claimWinner(dog);
        }

    }

}
