package OOP.homework.polymorphismHomeWork;

public class Satellite extends SpaceObject {

    private String accompaniedPlanet;


    public Satellite(String name, int weight, int square, boolean isInSolarSystem, String accompaniedPlanet) {
        super(name, weight, square, isInSolarSystem);
        this.accompaniedPlanet = accompaniedPlanet;
    }

    @Override
    public String toString() {
        return "Описание: имя - " + getName() +
                ", вес - " + getWeight() +
                ", площадь - " + getSquare() +
                ", сопровождаемая планета - " + accompaniedPlanet +
                ", находится в солнечной системе - " + getIsInSolarSystem();
    }
}
