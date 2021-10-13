package Encapsulation.Lab7_1;

import java.security.SecureRandom;

public class RandomSpeedGenerator {

    private int maxSpeed;
    private int minSpeed;

    public RandomSpeedGenerator(int maxSpeed, int minSpeed) {
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
    }

    public int selectRandomSpeed(SecureRandom secureRandom) {
        int selectSpeedIndex;
        int upperBound = getRange();
        int[] speedRange = initialSpeedRange();
        selectSpeedIndex = secureRandom.nextInt(upperBound);
        return speedRange[selectSpeedIndex];
    }

    private int[] initialSpeedRange() {
        int range = getRange();
        int[] speedRange = new int[range];
        for (int index = 0; index < range; index++) {
            speedRange[index] = minSpeed;
            minSpeed++;
        }
        return speedRange;
    }

    private int getRange() {
        int range = 0;
        if (maxSpeed > minSpeed)
            range = maxSpeed - minSpeed + 1;
        return range;
    }

}
