package Functions;

/*
* Задание 2

Даны 3 переменные:
- operand1 (double)
- operand2 (double)
- operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)

Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
Протестировать функцию в main.

Например:
Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
Результат: 34.5 (24.4 + 10.1)
*/

/*Мой комментарий:
* Не поняла нужно ли было выводить только лишь результат операции
* или результат операции и саму операцию в скобках (как в примере в задании), но на всякий случай вывела.
*/

public class functionsHomeworkTask2 {
    public static void main(String[] args) {
        double operand1 = 24.4;
        double operand2 = 10.1;
        char operation = '+';

        if (operation == '+' || operation == '-' || operation == '*' || operation == '/' || operation == '%') {
            System.out.println(getResultOfOperation(operand1, operand2, operation) + " (" + operand1 + " " + operation + " " + operand2 + ")");
        } else {
            System.out.println("incorrect symbol");
        }
    }

    public static double getResultOfOperation(double operand1, double operand2, char operation) {
        if (operation == '+') {
            return operand1 + operand2;
        } else if (operation == '-') {
            return operand1 - operand2;
        } else if (operation == '*') {
            return operand1 * operand2;
        } else if (operation == '/') {
            return operand1 / operand2;
        } else {
            return operand1 % operand2;
        }
    }


}
