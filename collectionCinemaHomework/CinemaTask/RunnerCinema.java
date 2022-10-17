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
    private static final int SIZE = 50;
    public static void main(String[] args) {
        Map<Integer, Set<Film>> allFilms = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            Film film = new Film(i + 1, 2000 + i, Month.APRIL, Genre.COMEDY, (double) i + 0.2);
            Set<Film> films = new LinkedHashSet<>();
            films.add(film);
            allFilms.put(film.getYear(), films);
        }


        Cinema cinema = new Cinema(allFilms);
        System.out.println(cinema);

        cinema.addFilm(new Film(4, 2020, Month.AUGUST, Genre.ANIME, 8.3));
        cinema.addFilm(new Film(8, 2015, Month.JULY, Genre.THRILLER, 5.8));
        cinema.addFilm(new Film(7, 2014, Month.JULY, Genre.HORROR, 3.8));
        System.out.println("Список фильмов после добавления: ");
        System.out.println(cinema);

        Set<Film> moviesByYear = cinema.getFilmsByYear(2000);
        System.out.println(moviesByYear);

        Set<Film> moviesByYearAndMonth = cinema.getFilmsByYearAndMonth(2015, Month.JULY);
        System.out.println(moviesByYearAndMonth);

        Set<Film> moviesByGenre = cinema.getFilmsByGenre(Genre.COMEDY);
        System.out.println(moviesByGenre);


    }

}
