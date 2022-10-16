package OOP.homework.polymorphismHomeWork;

public final class SpaceUtils {
    private static final int GRAVITATIONAL_CONSTANT = 7015;
    private static final int DISTANCE_BETWEEN_OBJECTS = 350;

    private SpaceUtils() {}

    public static double findTheForceOfGravity(SpaceObject spaceObject1, SpaceObject spaceObject2) {
        System.out.println("Сила гравитации между объектами " + spaceObject1.getName() + " и " + spaceObject2.getName() + ":");
        return GRAVITATIONAL_CONSTANT * ((double) (spaceObject1.getWeight() * spaceObject2.getWeight())/DISTANCE_BETWEEN_OBJECTS);
    }

    public static boolean isStar(SpaceObject spaceObject) {
        System.out.println("Является ли объект " + spaceObject.getName()+ " звездой: ");
        if(spaceObject instanceof Star) {
            return true;
        } else {
            return false;
        }
    }
}
