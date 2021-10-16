package Abstraction;

public class NonFlyAnimal extends Animal {

    private NonFlyAnimal(NonFlyAnimalBuilder builder) {
        super(builder.name, builder.type, builder.maxSpeed, builder.minSpeed);

        SpeedGenerator speedGenerator = new SpeedGenerator(builder.maxSpeed, builder.minSpeed);
        this.speed = speedGenerator.selectSpeed();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public boolean isFlyable() {
        return false;
    }

    public static class NonFlyAnimalBuilder extends AnimalBuilder<NonFlyAnimal> {

        private String name;
        private String type;
        private double maxSpeed;
        private double minSpeed;
        private double speed;

        @Override
        protected NonFlyAnimalBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        protected NonFlyAnimalBuilder setType(String type) {
            this.type = type;
            return this;
        }

        @Override
        protected NonFlyAnimalBuilder setMaxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        @Override
        protected NonFlyAnimalBuilder setMinSpeed(double minSpeed) {
            this.minSpeed = minSpeed;
            return this;
        }

        @Override
        protected Animal build() {
            return new NonFlyAnimal(this);
        }
    }
}
