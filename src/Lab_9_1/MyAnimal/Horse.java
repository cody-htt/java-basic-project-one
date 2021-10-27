package Lab_9_1.MyAnimal;

import Lab_9_1.AbstractAnimal.AnimalTemplate;

public class Horse extends AnimalTemplate {

    private final static double MAX_SPEED = 24.00D;
    private final static double MIN_SPEED = 15.00D;

    private Horse(String name , boolean isAllowToRace) {
        this.name = name;
        this.isAllowToRace = isAllowToRace;
        this.raceTime = 0;
        this.speed = calcSpeed();
    }

    public static Horse createHorse(String name , boolean isAllowToRace) {
        return new Horse(name , isAllowToRace);
    }

    private double calcSpeed() { return MIN_SPEED + ( random.nextDouble() * ( MAX_SPEED - MIN_SPEED ) ); }

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
    public String toString() {
        return String.format("The Horse with name " + this.name +
                ", is running at %.2f m/s" , this.speed);
    }

    @Override
    public boolean isAllowToRace() {
        return this.isAllowToRace;
    }
}
