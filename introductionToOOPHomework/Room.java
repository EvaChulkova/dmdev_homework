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

    public void setValue(boolean isPassageRoom) {
        this.isPassageRoom = isPassageRoom;
    }

    public void printState() {
        System.out.println("Проходная комната (true/false): " + isPassageRoom);
    }

}
