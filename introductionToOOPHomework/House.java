package OOP.homework.introductionToOOPHomework;

public class House {
    private int number;
    private Floor[] floors;

    public House(int number, Floor[] floors) {
        this.number = number;
        this.floors = floors;
    }

    public House() {}

    public Floor[] getFloors() {
        return floors;
    }

    public void printState() {
        System.out.println("Номер дома: " + number + ", количество этажей: " + Floor.getCounter());
    }
}
