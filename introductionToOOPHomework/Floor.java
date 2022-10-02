package OOP.homework.introductionToOOPHomework;

public class Floor {
    private int number;
    private Flat[] flats;
    private static int counter;

    public Floor(int number, Flat[] flats) {
        this.number = number;
        this.flats = flats;
        counter++;
    }

    public Floor() {}


    public Flat[] getFlats() {
        return flats;
    }

    public static int getCounter() {
        return counter;
    }

    public void printState() {
        System.out.println("Номер этажа: " + number + ", количество квартир: " + Flat.getCounter());
        getFlats();
    }
}
