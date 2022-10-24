package FunctionalProgramming.StreamHomework;

/*
* Задание 1

Дан список студентов с полями:
- Имя
- Фамилия
- Номер курса в университете
- Список оценок за учебу

Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:

Средняя оценка студентов этого курса, количество оценок у которых больше 3-х

Список студентов данного курса, но только с полями Имя и Фамилия.
Список должен быть отсортированы по этим двум полям

Объект с двумя полями:
- Отсортированный список студентов с пункта 2
- Средняя оценка этих студентов

Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
*/

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StudentsStreamRunner {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Anna", "Petrova", 2, List.of(5, 4, 5, 6, 7)),
                new Student("Nikita", "Sidorov", 4, List.of(3, 4, 5)),
                new Student("Maria", "Zotova", 5, List.of(8, 8, 6, 3, 5, 7)),
                new Student("Victor", "Ivanov", 1, List.of(5, 6, 7, 10, 10)),
                new Student("Andrew", "Dronov", 3, List.of(9, 5, 4, 8, 8)),
                new Student("Andrew", "Dronov", 3, List.of(10, 10, 10, 10))
        );


        Map<Integer, Double> averageGradesMap = students.stream()
                .filter(student -> student.getGrades().size() > 3)
                .collect(groupingBy(Student::getNumberOfCourse,
                        averagingDouble(student -> student.getGrades().stream()
                                .collect(averagingInt(Integer::intValue)))));
        System.out.println(averageGradesMap);

        Map<Integer, List<String>> sortedFirstAndLastNamesMap = students.stream()
                .sorted(new compareFirstNameComparator().thenComparing(new compareLastNameComparator()))
                .collect(groupingBy(Student::getNumberOfCourse,
                        mapping(student -> String.join(" ", student.getFirstName(), student.getLastName()),
                                collectingAndThen(toList(), e -> e.stream().collect(toList())))));
        System.out.println(sortedFirstAndLastNamesMap);



        Map<Integer, Map<Double, List<String>>> finalMap1 = students.stream()
                .collect(
                        groupingBy(
                                Student::getNumberOfCourse,
                                groupingBy(
                                        student -> student.getGrades().stream()
                                                .collect(averagingInt(Integer::intValue)),
                                        mapping(student -> String.join(" ", student.getFirstName(), student.getLastName()),
                                                collectingAndThen(toList(), e -> e.stream().sorted().collect(toList())))
                                )

                        )
                );
        System.out.println(finalMap1);

    }



    public static class compareFirstNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }

    public static class compareLastNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }
}
