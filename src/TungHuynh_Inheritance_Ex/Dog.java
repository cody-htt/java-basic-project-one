package TungHuynh_Inheritance_Ex;

import java.security.SecureRandom;

public class Dog extends Animal {

    static {
        animalName = "Dog";
        maxSpeed = 60;
        minSpeed = 40;
        randomSpeedGenerator = new RandomSpeedGenerator(maxSpeed, minSpeed);
    }

    public Dog() {
        super(0);
    }

    public static String getDefaultName() {
        if (animalName == null)
            return "This is class Dog";

        return animalName;
    }

    public void setDogSpeed(SecureRandom secureRandom) {
        int speed = randomSpeedGenerator.selectRandomSpeed(secureRandom);
        super.setSpeed(speed);
    }

}
