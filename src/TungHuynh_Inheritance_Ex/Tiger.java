package TungHuynh_Inheritance_Ex;

import java.security.SecureRandom;

public class Tiger extends Animal {

    static {
        animalName = "Tiger";
        maxSpeed = 85; // given maxSpeed = 100, I change the max speed of the tiger because it always wins :)
        minSpeed = 35;
        randomSpeedGenerator = new RandomSpeedGenerator(maxSpeed, minSpeed);
    }

    public Tiger() {
        super(0);
    }

    public static String getDefaultName() {
        if (animalName == null)
            return "This is class Tiger";

        return animalName;
    }

    public void setTigerSpeed(SecureRandom secureRandom) {
        int speed = randomSpeedGenerator.selectRandomSpeed(secureRandom);
        super.setSpeed(speed);
    }

}
