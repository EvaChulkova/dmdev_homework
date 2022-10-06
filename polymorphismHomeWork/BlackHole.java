package OOP.homework.polymorphismHomeWork;

public class BlackHole extends SpaceObject{

    private int amount;

    public BlackHole(String name, int weight, int square, boolean isInSolarSystem, int amount) {
        super(name, weight, square, isInSolarSystem);
        this.amount = amount;
    }

    @Override
    public String toString() {
          return "Описание: имя - " + getName() +
                ", вес - " + getWeight() +
                  ", площадь - " + getSquare() +
                ", количество объектов, затянутых в черную дыру - " + amount +
                  ", находится в солнечной системе - " + getIsInSolarSystem();
    }
}
