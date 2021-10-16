package Abstraction;

public abstract class Animal {

    protected String name;
    protected String type;
    protected double maxSpeed;
    protected double minSpeed;
    protected double speed;

    protected Animal(String name, String type, double maxSpeed, double minSpeed) {
        this.name = name;
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
    }

    public abstract String getName();
    public abstract String getType();
    public abstract double getSpeed();
    public abstract boolean isFlyable();

    @Override
    public String toString() {
        return "The " + getType().toUpperCase() +
                " with name " + getName().toUpperCase();
    }

}
