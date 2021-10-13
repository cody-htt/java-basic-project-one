package Encapsulation.Lab7_1;

import java.security.SecureRandom;
import java.util.Locale;

public class Animal {

    public final static SecureRandom SECURE_RANDOM = new SecureRandom();

    //Final Fields
    private final String name; //Require fields
    private final String type; //Require fields
    private final boolean feet;
    private final boolean wings;
    private final boolean isAllowToRace;
    private final int selectSpeed;

    //Static Fields
    private final RandomSpeedGenerator randomSpeedGenerator;

    private Animal(AnimalBuilder animalBuilder) {
        this.name = animalBuilder.name;
        this.type = animalBuilder.type;
        this.feet = animalBuilder.feet;
        this.wings = animalBuilder.wings;
        this.isAllowToRace = animalBuilder.isAllowToRace;

        //Declare needed variables
        int maxSpeed = animalBuilder.maxSpeed;
        int minSpeed = animalBuilder.minSpeed;
        this.randomSpeedGenerator = new RandomSpeedGenerator(maxSpeed, minSpeed);
        this.selectSpeed = setAnimalSpeed();
    }

    private int setAnimalSpeed() {
        return randomSpeedGenerator.selectRandomSpeed(SECURE_RANDOM);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isAllowToRace() {
        return isAllowToRace;
    }

    public int getSelectSpeed() {
        return selectSpeed;
    }

    public static class AnimalBuilder {

        private String type; //Require fields
        private String name; //Require fields
        private int maxSpeed;
        private int minSpeed;
        private boolean feet;
        private boolean wings;
        private boolean isAllowToRace;

        public AnimalBuilder(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public AnimalBuilder setMaxSpeed (int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public AnimalBuilder setMinSpeed (int minSpeed) {
            this.minSpeed = minSpeed;
            return this;
        }

        public AnimalBuilder isMoveByFeet (boolean feet) {
            this.feet = feet;
            return this;
        }

        public AnimalBuilder hasWings (boolean wings) {
            this.wings = wings;
            return this;
        }

        public Animal build() {
            validateAnimeIsAllowed();
            validateAnimalObject();

            return new Animal(this);
        }

        /*
        This method is used to check if the animal is able to fly,
        if it is -> NOT ALLOW TO INSTANTIATE THIS ANIMAL !!!
         */
        private void validateAnimeIsAllowed () {
            if (this.wings && this.feet) {
                this.isAllowToRace = false;
            } else if (!this.wings && this.feet) {
                this.isAllowToRace = true;
            }
        }

        /*
        Validate animal type and name is not NULL
         */
        private void validateAnimalObject () {
            if (this.name == null || this.type == null) {
                this.isAllowToRace = false;
            }
        }

    }
}
