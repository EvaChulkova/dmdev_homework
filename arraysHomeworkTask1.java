package arrays;

/*Задание 1
Дан одномерный массив целых чисел.
Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
После удаления - умножить каждый элемент массива на его длину.
Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]

Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.*/

import java.util.Arrays;

public class arraysHomeworkTask1 {
    public static void main(String[] args) {
        int[] array = {3, 5, -6, 3, 2, -9, 0, -123};

        int[] posArray = removeNegativeElements(array);
        //System.out.println(Arrays.toString(posArray));

        int[] multiplyOnLength = multiplyPositiveElementsOnLength(posArray);
        System.out.println(Arrays.toString(multiplyOnLength));
    }

    public static int[] removeNegativeElements(int[] array) {
        int amountOfPositiveElements = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                amountOfPositiveElements++;
            }
        }
        
        int[] positiveArray = new int[amountOfPositiveElements];
        int indexPositive = 0;

        for (int i : array) {
            if (i >= 0) {
                positiveArray[indexPositive] = i;
                indexPositive++;
            }
        }
        return positiveArray;
    }

    public static int[] multiplyPositiveElementsOnLength(int[] posArray) {
        int lengthOfPositiveArray = posArray.length;

        int[] multiplyArray = new int[lengthOfPositiveArray];
        for (int i = 0; i < multiplyArray.length; i++) {
            multiplyArray[i] = posArray[i] * lengthOfPositiveArray;
        }
        return multiplyArray;
    }
}
