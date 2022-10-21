package Collections.homework.collectionCinemaHomework.CinemaTask;

/*
* Задание 1

Даны 2 класса:
- Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
- Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив, где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.

Добавить функционал в кинотеатр таким образом, чтобы можно было:
- добавлять в него новый фильм
- получить все фильмы по переданному году
- получить все фильмы по переданному году и месяцу
- получить все фильмы по переданному жанру
- получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания

Учесть следующее:

- в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)

- не должен добавляться фильм, если такой уже есть в кинотеатре

Продемонстрировать работу кинотеатра в отдельном классе.
* */

import Collections.homework.collectionCinemaHomework.enums.Genre;
import Collections.homework.collectionCinemaHomework.enums.Month;

import java.util.*;

public class RunnerCinema {
    private static final int AMOUNT_OF_TOP_FILMS = 10;

    public static void main(String[] args) {
        Map<Integer, LinkedHashSet<Film>> allFilms = new LinkedHashMap<>();
        LinkedHashSet<Film> films = new LinkedHashSet<>();

        Film film1 = new Film(1, 2000, Month.APRIL, Genre.ANIME, 5.4);
        Film film2 = new Film(2, 2000, Month.MARCH, Genre.HORROR, 3.3);

        films.add(film1);
        films.add(film2);

        allFilms.put(film1.getYear(), films);


        Cinema cinema = new Cinema(allFilms);
        System.out.println(cinema);

        cinema.addFilm(new Film(4, 2001, Month.AUGUST, Genre.ANIME, 8.3));
        cinema.addFilm(new Film(8, 2000, Month.JULY, Genre.THRILLER, 5.8));
        cinema.addFilm(new Film(7, 2002, Month.JULY, Genre.HORROR, 3.8));
        System.out.println("Список фильмов после добавления: ");
        System.out.println(cinema);

        System.out.println("Список фильмов по переданому году: ");
        System.out.println(cinema.getFilmsByYear(2000));

        System.out.println("Список фильмов по переданному году и жанру: ");
        System.out.println(cinema.getFilmsByYearAndMonth(2000, Month.JULY));

        System.out.println("Список фильмов по переданному жанру: ");
        cinema.getFilmsByGenre(Genre.ANIME);

        List<Film> topList = cinema.getTop10Films();
        System.out.println("Список фильмов по рейтингу (в порядке убывания): " + "\n" + topList);


    }

}
