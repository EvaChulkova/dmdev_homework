package OOP.homework.polymorphismHomeWork;

public class Star extends SpaceObject {
    private boolean isStar;
    private int age;

    public Star(String name, int weight, int square, boolean isInSolarSystem, int age) {
        super(name, weight, square, isInSolarSystem);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Описание: имя - " + getName() +
                ", вес - " + getWeight() +
                ", площадь - " + getSquare() +
                ", возраст звезды - " + age +
                ", находится в солнечной системе - " + getIsInSolarSystem();
    }
}
