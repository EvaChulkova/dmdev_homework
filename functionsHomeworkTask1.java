package Functions;

/*
* Задание 1

В переменной minutes лежит число от 0 до 59.
Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).

Протестировать функцию в main.
* */

public class functionsHomeworkTask1 {
    public static void main(String[] args) {
        int minute = 16;

        if (minute >= 0 && minute < 60) {
            System.out.println(getQuater(minute));
        } else {
            System.out.println("минуты введены некорректно");
        }

    }

    public static String getQuater (int value) {
        if (value >= 0 && value <= 15) {
            return "первая четверть";
        } else if (value >= 16 && value <= 30) {
            return "вторая четверть";
        } else if (value >= 31 && value <= 45) {
            return "третья четверть";
        } else {
            return "четвертая четверть";
        }
    }
}
