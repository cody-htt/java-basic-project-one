package Abstraction;

import java.util.Random;

public class SpeedGenerator {

    private final double maxSpeed;
    private final double minSpeed;
    private final Random random;

    public SpeedGenerator(double maxSpeed, double minSpeed) {
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.random = new Random();
    }

    public double selectSpeed() {
        double speed = 0D;
        if (getRange() > 0) {
            speed = minSpeed + (random.nextDouble() * getRange());
        }
        return speed;
    }

    private double getRange() {
        return (this.maxSpeed - this.minSpeed);
    }

}
