package OOP.homework.introductionToOOPHomework;

public class Room {

    private boolean isPassageRoom;
    private static int counter;

    public Room(boolean isPassageRoom) {
        this.isPassageRoom = isPassageRoom;
        counter++;
    }

    public Room() {}

    public boolean getValue() {
        return isPassageRoom;
    }

    public static int getCounter() {
        return counter;
    }

    public void printState() {
        if (isPassageRoom) {
            System.out.println("Проходная комната");
        } else {
            System.out.println("Непроходная комната");
        }
    }
}
