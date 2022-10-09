package OOP.homework.polymorphismHomeWork;

public abstract class SpaceObject {
    public static final double PI = 3.14;
    private String name;
    private int weight;
    private int square;
    private boolean isInSolarSystem;

    public SpaceObject(String name, int weight, int square, boolean isInSolarSystem) {
        this.name = name;
        this.weight = weight;
        this.square = square;
        this.isInSolarSystem = isInSolarSystem;
    }

    public double findDiameter() {
        System.out.println("Диаметр объекта " + getName() + ": ");
        return 2 * Math.sqrt(getSquare()/(4 * PI));
    }

    public void compareWeight(SpaceObject spaceObject) {
        if (getWeight() > spaceObject.getWeight()) {
            System.out.println("Объект " + getName() + " тяжелеее объекта " + spaceObject.getName());
        } else if (getWeight() < spaceObject.getWeight()) {
            System.out.println("Объект " + getName() + " легче объекта " + spaceObject.getName());
        } else {
            System.out.println("Массы объектов равны");
        }
    }

    public boolean getIsInSolarSystem() {
        return isInSolarSystem;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getSquare() {
        return square;
    }
}
