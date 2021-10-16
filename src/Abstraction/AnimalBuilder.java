package Abstraction;

public abstract class AnimalBuilder<T extends Animal> {

    protected abstract AnimalBuilder<T> setName(String name);
    protected abstract AnimalBuilder<T> setType(String type);
    protected abstract AnimalBuilder<T> setMaxSpeed(double maxSpeed);
    protected abstract AnimalBuilder<T> setMinSpeed(double minSpeed);
    protected abstract Animal build();

}
