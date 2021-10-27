package Lab_9_1.MyAnimal;

import Lab_9_1.AbstractAnimal.AnimalTemplate;

public class Elephant extends AnimalTemplate {

    private final static double LONGEST_STRIDE = 4.00D;
    private final static double SMALLEST_STRIDE = 3.00D;
    private final static double SPEED_RATIO = 6.00D;

    private Elephant(String name , boolean isAllowToRace) {
        this.name = name;
        this.isAllowToRace = isAllowToRace;
        this.raceTime = 0;
        this.speed = calcSpeed();
    }

    public static Elephant createElephant(String name , boolean isAllowToRace) {
        return new Elephant(name , isAllowToRace);
    }

    private double calcSpeed() {
        return SPEED_RATIO * calcStride();
    }

    private double calcStride() {
        return SMALLEST_STRIDE + (random.nextDouble() * (LONGEST_STRIDE - SMALLEST_STRIDE));
    }

    @Override
    public String toString() {
        return String.format("The Elephant with name " + this.name +
                ", is running at %.2f m/s" , this.speed);
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public int getRaceTime() {
        return this.raceTime;
    }

    @Override
    public void setRaceTime() {
        this.raceTime++;
    }

    @Override
    public boolean isAllowToRace() {
        return this.isAllowToRace;
    }
}

