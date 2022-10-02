package OOP.homework.introductionToOOPHomework;

/*Задание 1

Представить в виде классов и их композиции следующую модель:
- Каждый дом содержит свой номер (int), и множество этажей (массив).
- Каждый этаж содержит номер этажа (int), и множество квартир (массив).
- Каждая квартира содержит свой номер (int), и множество комнат (массив).
- Каждая комната содержит поле проходная она или нет (boolean).

В каждом классе реализовать метод print, который на консоль выводит информацию об объекте (должны присутствовать все поля объекта!).

Например, метод print класса этаж должен выводить на консоль:
“Этаж 2, количество квартир 18”

Создание всех объектов вынести в отдельный класс с методом main.

Там же реализовать метод printAllInformation, который на вход принимает объект типа дом, и выводит информацию о нем,
его этажах, квартирах и комнатах, вызывая методы print.*/


public class Runner {
    public static void main(String[] args) {

        Room[] rooms = new Room[2];
        for (int i = 0; i < rooms.length; i++) {
            if (i % 2 == 0) {
                rooms[i] = new Room(true);
            } else {
                rooms[i] = new Room(false);
            }
        }

        Flat[] flats = new Flat[2];
        for (int i = 0; i < flats.length; i++) {
            flats[i] = new Flat(1, rooms);
            flats[i].printState();
        }
        //flats[1].printState();

        Floor[] floors = new Floor[3];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(2, flats);
            floors[i].printState();
        }
        //floors[1].printState();

        House[] houses = new House[3];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = new House(5, floors);
            houses[i].printState();
        }
        //houses[1].printState();

        printAllInformation(houses[1]);

    }

    public static void printAllInformation(House houses) {
        houses.printState();
        //houses.getFloors().printState();
        //houses.getFloors().getFlats().printState();
        //houses.getFloors().getFlats().getRooms().getState();

    }
}
