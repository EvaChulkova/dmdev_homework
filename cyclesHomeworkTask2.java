package cycles;

/*
* Задание 2
Дано целое число.
Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
Результат вывести на консоль.
Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321

Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
* */

public class cyclesHomeworkTask2 {
    public static void main(String[] args) {
        int number = 1234567;

        while (number != 0) {
            int res = oppNumber(number);
            System.out.print(res);
            number /= 10;
        }
    }

    public static int oppNumber(int value) {
        int oppositeNumber = value;
        oppositeNumber = oppositeNumber % 10;
        return oppositeNumber;
    }
}
