package TungHuynh_Inheritance_Ex;

public class Animal {

    private int speed;

    protected static int maxSpeed;
    protected static int minSpeed;
    protected static RandomSpeedGenerator randomSpeedGenerator;
    protected static String animalName = "This is the Animal Class";

    public Animal() {
    }

    public Animal(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void claimWinner(Animal animal) {
        String animalType = animal.getClass().getSimpleName();
        System.out.println("The Winner is " + animalType + ", with speed: " + this.speed);
    }

}
