package cycles;

/*
* Задание 1
Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
Для решения написать 2 функции, которые будут принимать введенное целое число,
* а возвращать количество четных цифр (вторая функция - нечетных).

Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
*/

public class cyclesHomeworkTask1 {
    public static void main(String[] args) {
        int value = 228910;
        int res = evenNumber(value);
        System.out.println("\n" + "Четных чисел:" + res);

        int resOdd = oddNumber(value);
        System.out.println("\n" + "Нечетных чисел:" + resOdd);


    }

    public static int evenNumber(int value) {
        int count = 0;
        int evenValue;

        for (int i = value; i != 0 ; i /= 10) {
            if ((evenValue = i % 10) % 2 == 0) {
                count++;
                System.out.print(evenValue + ",");
            }
        }
        return count;
    }

    public static int oddNumber(int value) {
        int countOdd = 0;
        int oddValue;

        for (int i = value; i != 0 ; i /= 10) {
            if ((oddValue = i % 10) % 2 != 0) {
                countOdd++;
                System.out.print(oddValue + ",");
            }
        }
        return countOdd;
    }








}
