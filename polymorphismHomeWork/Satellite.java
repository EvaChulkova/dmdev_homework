package OOP.homework.polymorphismHomeWork;

public class Satellite extends SpaceObject {
    private String accompaniedPlanet;

    public Satellite(String name, int weight, int square, boolean isInSolarSystem, String accompaniedPlanet) {
        super(name, weight, square, isInSolarSystem);
        this.accompaniedPlanet = accompaniedPlanet;
    }

    public void satelliteRotation() {
        System.out.println("Я спутник и вращаюсь вокруг сопровождаемой планеты " + accompaniedPlanet + " со скоростью 2 оборота в час");
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
