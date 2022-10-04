package OOP.homework;

/*Дана строка.
Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
Результат привести к верхнему регистру.

Например:
"abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"*/

public class stringHomeworkTask1 {
    public static final String EMPTY = "";
    public static final String FULL = " ";

    public static void main(String[] args) {
        String value = "abc Cpddd Dio OsfWwt";

        String changedString = createString(value);
        System.out.println(changedString);
    }

    private static String createString(String value) {
        String result = value.replace(FULL, EMPTY).toUpperCase();
        char[] chars = result.toCharArray();

        char previousLetter = chars[0];
        StringBuilder uniqueLetters = new StringBuilder();
        uniqueLetters.insert(0, previousLetter);
        int indexStringBuilder = 1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] != previousLetter) {
                uniqueLetters.insert(indexStringBuilder, chars[i]);
                previousLetter = chars[i];
                indexStringBuilder++;
            }
        }
        return uniqueLetters.toString();
    }
}
