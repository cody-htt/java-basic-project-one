package Lab_9_1.AbstractAnimal;

import java.util.Random;

public abstract class AnimalTemplate implements IRaceAnimal {

    protected final Random random = new Random();

    protected String name;
    protected double speed;
    protected boolean isAllowToRace;
    protected int raceTime;

    public abstract double getSpeed();

    public abstract int getRaceTime();

    public abstract void setRaceTime();
}

