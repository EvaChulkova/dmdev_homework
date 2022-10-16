package OOP.homework.polymorphismHomeWork;

public class Asteroid extends SpaceObject implements Flyable {
    private int speed;

    public Asteroid(String name, int weight, int square, boolean isInSolarSystem, int speed) {
        super(name, weight, square, isInSolarSystem);
        this.speed = speed;
    }

    @Override
    public boolean isControlledFlight() {
        if (speed < 700) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Описание: имя - " + getName() +
                ", вес - " + getWeight() +
                ", площадь - " + getSquare() +
                ", скорость - " + speed +
                ", совершает контролируемый полёт - " + isControlledFlight() +
                ", находится в солнечной системе - " + getIsInSolarSystem();
    }

    public int getSpeed() {
        return speed;
    }
}
