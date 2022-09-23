package Functions;

/*
* Задание 3

Даны два прямоугольных треугольника.
Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.

Для этого понадобится написать 2 функции.
Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
Учитывать, что площадь может быть вещественным числом.
*/

public class functionsHomeworkTask3 {
    public static void main(String[] args) {
        int a = 5;
        int b = 4;
        int c = 3;
        int d = 6;


        double square1 = getSquare(a, b);
        System.out.println("Площадь первого треугольника: " + square1);

        double square2 = getSquare(c, d);
        System.out.println("Площадь второго треугольника: " + square2);

        System.out.println(getSizeOfSquares(square1, square2));
    }


    public static double getSquare (int value1, int value2) {
        double square = 0.5 * value1 * (double) value2;
        return square;
    }

    public static String getSizeOfSquares(double square1, double square2) {
        if (square1 > square2) {
            return "Первый треугольник больше второго";
        } else if (square1 < square2) {
            return "Первый треугольник меньше второго";
        } else {
            return "Треугольники равны";
        }
    }
}
