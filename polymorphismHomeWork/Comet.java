package OOP.homework.polymorphismHomeWork;

public class Comet extends SpaceObject implements Flyable{

    private int tailLength;
    private int speed;

    public Comet(String name, int weight, int square, boolean isInSolarSystem, int tailLength, int speed) {
        super(name, weight, square, isInSolarSystem);
        this.tailLength = tailLength;
        this.speed = speed;
    }

    @Override
    public boolean isControlledFlight() {
        if (speed < 300) {
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
                ", длина хвоста - " + tailLength +
                ", скорость - " + speed +
                ", совершает котролируемый полёт - " + isControlledFlight() +
                ", находится в солнечной системе - " + getIsInSolarSystem();
    }
}
