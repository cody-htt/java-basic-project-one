package Lab_9_1.MyAnimal;

import Lab_9_1.AbstractAnimal.AnimalTemplate;

public class Tiger extends AnimalTemplate {

    private final static double MAX_WEIGHT = 400.00D;
    private final static double MIN_WEIGHT = 250.00D;
    private final static double RATIO_SPEED = 0.06D;

    private Tiger(String name , boolean isAllowToRace) {
        this.name = name;
        this.isAllowToRace = isAllowToRace;
        this.raceTime = 0;
        this.speed = calcSpeed();
    }

    public static Tiger createTiger(String name , boolean isAllowToRace) {
        return new Tiger(name , isAllowToRace);
    }

    private double calcSpeed() {
        return RATIO_SPEED * calcWeight();
    }

    private double calcWeight() {
        return MIN_WEIGHT + (random.nextDouble() * (MAX_WEIGHT - MIN_WEIGHT));
    }

    @Override
    public String toString() {
        return String.format("The Tiger with name " + this.name +
                " is running at %.2f m/s" , this.speed);
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
