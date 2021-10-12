package TungHuynh_Inheritance_Ex;

import java.security.SecureRandom;

public class Horse extends Animal {

    static {
        animalName = "Horse";
        maxSpeed = 75;
        minSpeed = 35;
        randomSpeedGenerator = new RandomSpeedGenerator(maxSpeed, minSpeed);
    }

    public Horse() {
        super(0);
    }

    public static String getDefaultName() {
        if (animalName == null)
            return "This is class Horse";

        return animalName;
    }

    public void setHorseSpeed(SecureRandom secureRandom) {
        int speed = randomSpeedGenerator.selectRandomSpeed(secureRandom);
        super.setSpeed(speed);
    }

}
