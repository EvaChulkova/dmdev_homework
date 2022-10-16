package OOP.homework.polymorphismHomeWork;

public class Star extends SpaceObject {
    private boolean isStar;
    private int age;

    public Star(String name, int weight, int square, boolean isInSolarSystem, int age) {
        super(name, weight, square, isInSolarSystem);
        this.age = age;
    }

    public void transformationIntoSupernova() {
        if (age > 3500) {
            System.out.println("Я взрослая звезда и превращаюсь в сверхновую.");
        } else {
            System.out.println("Я молодая звезда и преращение в сверхновую произойдёт нескоро.");
        }
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
