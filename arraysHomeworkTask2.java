package arrays;

/*Задание 2
Дан одномерный массив символов.

Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]

Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы, которые больше этого среднего арифметического.
*/

public class arraysHomeworkTask2 {
    public static void main(String[] args) {
        char[] chars = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        toAscii(chars);
    }

    public static void toAscii(char[] chars) {
        int[] ascii = new int[chars.length];
        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            ascii[i] = chars[i];
            sum = sum + ascii[i];
            //System.out.print(ascii[i] + " ");
        }
        //System.out.println();
        //System.out.println("Сумма элементов массива: " + sum);

        double average = (double) sum / ascii.length;
        //System.out.println("Среднее арифметическое: " + average);

        for (int i = 0; i < ascii.length; i++) {
            if(ascii[i] > average) {
                System.out.print(ascii[i] + " ");
            }
        }
        System.out.println();
    }
}
