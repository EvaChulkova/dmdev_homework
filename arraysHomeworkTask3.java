package arrays;

/*Задание 3
Дан одномерный массив целых чисел.

Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
Если для какого-то из массивов не будет значений, то должен быть создан пустой массив. Возвращает функция эти три массива в виде одного двумерного.

Пример:
                            [-4, -18]
[-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
                            [1, 9, 3]
*/

import java.util.Arrays;

public class arraysHomeworkTask3 {
    public static void main(String[] args) {
        int[] array = {-4, 0, 1, 9, 0, -18, 3};

        int[][] arrayOfArrays = decomposeArray(array);
        printArrayOfArrays(arrayOfArrays);

    }

    private static int[][] decomposeArray(int[] array) {
        int amountOfPos = 0;
        int amountOfNeg = 0;
        int amountOfZeros = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                amountOfPos++;
            } else if (array[i] < 0) {
                amountOfNeg++;
            } else {
                amountOfZeros++;
            }
        }

        int[] posArray = new int[amountOfPos];
        int[] negArray = new int[amountOfNeg];
        int[] zeroArray = new int[amountOfZeros];

        int posIndex = 0;
        int negIndex = 0;
        int zeroIndex = 0;

        for (int elOfArray : array) {
            if (elOfArray > 0) {
                posArray[posIndex] = elOfArray;
                posIndex++;
            } else if (elOfArray < 0) {
                negArray[negIndex] = elOfArray;
                negIndex++;
            } else {
                zeroArray[zeroIndex] = elOfArray;
                zeroIndex++;
            }
        }

        /*
        System.out.println();
        System.out.println(Arrays.toString(posArray));
        System.out.println(Arrays.toString(negArray));
        System.out.println(Arrays.toString(zeroArray));
         */

        int[][] arrayOfArrays = new int[3][];
        arrayOfArrays[0] = posArray;
        arrayOfArrays[1] = negArray;
        arrayOfArrays[2] = zeroArray;

        return arrayOfArrays;
    }

    public static void printArrayOfArrays(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] ints = array[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
