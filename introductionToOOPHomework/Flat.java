package OOP.homework.introductionToOOPHomework;

public class Flat {
    private Room[] rooms;
    private int number;
    private static int counter;

    public Flat(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
        counter++;
    }

    public Flat() {}

    public Room[] getRooms() {
        return rooms;
    }

    public static int getCounter() {
        return counter;
    }

    public void printState() {
        System.out.println("Номер квартиры: " + number + ", количество комнат: " + Room.getCounter());
    }
}
