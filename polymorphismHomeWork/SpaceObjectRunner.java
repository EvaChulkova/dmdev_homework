package OOP.homework.polymorphismHomeWork;

public class SpaceObjectRunner {

    public static void main(String[] args) {
        SpaceObject planet1 = new Planet("Земля", 316, 400, true, 805);
        SpaceObject satellite1 = new Satellite("Спутник", 199, 210, true, "Планеточка");
        SpaceObject star1 = new Star("Звезда", 203, 158, false, 5000);
        SpaceObject asteroid1 = new Asteroid("Астероид", 239, 268, false, 476);
        SpaceObject comet1 = new Comet("Комета", 377, 496, false, 700, 300);
        SpaceObject blackHole1 = new BlackHole("Черная дыра", 4000, 5000, false, 7000);

        printInfoAboutSpaceObjects(planet1, satellite1, star1, asteroid1, comet1, blackHole1);
        System.out.println();

        System.out.println(SpaceUtils.isStar(star1));
        System.out.println(SpaceUtils.findTheForceOfGravity(planet1, satellite1));

        System.out.println(satellite1.findDiameter());
        star1.compareWeight(comet1);

    }

    public static void printInfoAboutSpaceObjects(SpaceObject... spaceObjects) {
        for (SpaceObject spaceObject : spaceObjects) {
            System.out.println(spaceObject);
        }
    }
}
