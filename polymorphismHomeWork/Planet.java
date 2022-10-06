package OOP.homework.polymorphismHomeWork;

public class Planet extends SpaceObject {
    private int speed;

    public Planet(String name, int weight, int square, boolean isInSolarSystem, int speed) {
        super(name, weight, square, isInSolarSystem);
        this.speed = speed;
    }

    public String findTypeOfPlanet() {
        if (getSquare() > 0) {
            if (getSquare() > 0 && getSquare() < 100) {
                return "Карликовая планета";
            } else if (getSquare() > 500) {
                return "Планета-гигант";
            } else {
                return "Планета средних размеров";
            }
        } else {
            return "Введите корректное значение размера планеты для определения её типа: карликовая, гигант или средних размеров";
        }
    }

    @Override
    public String toString (){
        return "Описание: имя - " + getName() +
                ", вес - " + getWeight() +
                ", площадь - " + getSquare() +
                ", скорость движения по орбите - " + speed +
                ", тип планеты - " + findTypeOfPlanet() +
                ", находится в солнечной системе - " + getIsInSolarSystem();
    }
}
