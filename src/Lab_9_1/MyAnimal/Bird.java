package Lab_9_1.MyAnimal;

import Lab_9_1.AbstractAnimal.AnimalTemplate;

public class Bird extends AnimalTemplate {

    private final static double MAX_FLYING_SPEED = 500.00D;
    private final static double MIN_FLYING_SPEED = 200.00D;

    private Bird(String name , boolean isAllowToRace) {
        this.name = name;
        this.isAllowToRace = isAllowToRace;
        this.raceTime = 0;
        this.speed = calcSpeed();
    }

    public static Bird createBird(String name , boolean isAllowToRace) {
        return new Bird(name , isAllowToRace);
    }

    private double calcSpeed() { return MIN_FLYING_SPEED + (random.nextDouble() * (MAX_FLYING_SPEED - MIN_FLYING_SPEED)); }

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
        return String.format("The Bird with name " + this.name +
                ", is flying at %.2f m/s but it is not allowed to join the race" , this.speed);
    }

    @Override
    public boolean isAllowToRace() {
        return this.isAllowToRace;
    }
}

