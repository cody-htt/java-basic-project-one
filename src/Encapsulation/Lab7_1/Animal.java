package Encapsulation.Lab7_1;

import java.security.SecureRandom;

public class Animal {

    //Final Fields
    private final String name; //Require fields
    private final String type; //Require fields
    private final boolean hasFeet;
    private final boolean hasWings;
    private final boolean isAllowToRace;
    private final int speed;

    private Animal(AnimalBuilder animalBuilder) {
        this.name = animalBuilder.name;
        this.type = animalBuilder.type;
        this.hasFeet = animalBuilder.hasFeet;
        this.hasWings = animalBuilder.hasWings;
        this.isAllowToRace = animalBuilder.isAllowToRace;
        this.speed = animalBuilder.speed;
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

    public int getSpeed() {
        return speed;
    }

    public static class AnimalBuilder {

        //Class Variable
        private final static SecureRandom SECURE_RANDOM = new SecureRandom();

        private final String type; //Require fields
        private final String name; //Require fields
        private int maxSpeed;
        private int minSpeed;
        private int speed;
        private boolean hasFeet;
        private boolean hasWings;
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
            this.hasFeet = feet;
            return this;
        }

        public AnimalBuilder hasWings (boolean wings) {
            this.hasWings = wings;
            return this;
        }

        public Animal build() {
            validateAnimeIsAllowed();
            validateAnimalObject();
            validateSpeedRange();
            this.speed = setAnimalSpeed(this.maxSpeed, this.minSpeed);

            return new Animal(this);
        }

        private int setAnimalSpeed(int maxSpeed, int minSpeed) {
            RandomSpeedGenerator randomSpeedGenerator = new RandomSpeedGenerator(maxSpeed, minSpeed);
            return randomSpeedGenerator.selectRandomSpeed(SECURE_RANDOM);
        }

        /*
        This method is used to check if the animal is able to fly,
        if it is -> NOT ALLOW TO INSTANTIATE THIS ANIMAL !!!
         */
        private void validateAnimeIsAllowed () {
            if (!this.hasFeet) {
                this.isAllowToRace = false;
            } else this.isAllowToRace = !this.hasWings;
        }

        /*
        Validate animal type and name is not NULL
         */
        private void validateAnimalObject () {
            if (this.name == null || this.type == null) {
                this.isAllowToRace = false;
            }
        }

        /*
        Validate the speed range is correct
         */
        private void validateSpeedRange() {
            if (this.maxSpeed - this.minSpeed <= 0) {
                this.isAllowToRace = false;
            }
        }

    }
}
