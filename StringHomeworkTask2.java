package OOP.homework;

/*Задание 2
Дана строка с текстом, в котором есть цифры от 0 до 9.

Написать 2 метода:

- возвращающий массив цифр из переданной строки
- возвращающий сумму цифр из переданного целочисленного массива

Посчитать сумму всех чисел из строки

Например:
“Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)*/

import java.util.Arrays;

public class StringHomeworkTask2 {
    public static void main(String[] args) {
        String value = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";

        int[] numbers = makeArrayOfNumbers(value);
        System.out.println(Arrays.toString(numbers));

        int sum = findSumOfNumbersInArray(numbers);
        System.out.println(sum);
    }

    private static int[] makeArrayOfNumbers(String value) {
        char[] charArray = value.toCharArray();
        StringBuilder stringBuilderOfNumbers = new StringBuilder();
        int indexStringBuilder = 0;

        for (int i = 0; i < charArray.length; i++) {
            if(Character.isDigit(charArray[i])) {
                stringBuilderOfNumbers.insert(indexStringBuilder, charArray[i]);
                indexStringBuilder++;
            }
        }

        String[] symbols = stringBuilderOfNumbers.toString().split("");
        int[] numbers = new int[symbols.length];
        for (int i = 0; i < symbols.length; i++) {
            numbers[i] = Integer.parseInt(symbols[i]);
        }
        return numbers;
    }

    private static int findSumOfNumbersInArray(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result = result + numbers[i];
        }
        return result;
    }
}
