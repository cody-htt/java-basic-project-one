package Abstraction;

public class FlyableAnimal extends Animal {

    private final boolean isFlyable;

    private FlyableAnimal(FlyableAnimalBuilder builder) {
        super(builder.name, builder.type, builder.maxSpeed, builder.minSpeed);
        this.isFlyable = builder.isFlyable;

        SpeedGenerator speedGenerator = new SpeedGenerator(builder.maxSpeed, builder.minSpeed);
        this.speed = speedGenerator.selectSpeed();
    }

    public boolean isFlyable() {
        return this.isFlyable;
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

    public static class FlyableAnimalBuilder extends AnimalBuilder<FlyableAnimal> {

        private String name;
        private String type;
        private double maxSpeed;
        private double minSpeed;
        private boolean isFlyable;

        @Override
        protected FlyableAnimalBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        protected FlyableAnimalBuilder setType(String type) {
            this.type = type;
            return this;
        }

        @Override
        protected FlyableAnimalBuilder setMaxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        @Override
        protected FlyableAnimalBuilder setMinSpeed(double minSpeed) {
            this.minSpeed = minSpeed;
            return this;
        }

        public FlyableAnimalBuilder checkFlyAbility(boolean isFlyable) {
            this.isFlyable = isFlyable;
            return this;
        }

        @Override
        protected Animal build() {
            return new FlyableAnimal(this);
        }
    }
}
