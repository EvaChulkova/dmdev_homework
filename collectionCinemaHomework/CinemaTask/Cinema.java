package Collections.homework.collectionCinemaHomework.CinemaTask;

import Collections.homework.collectionCinemaHomework.enums.Genre;
import Collections.homework.collectionCinemaHomework.enums.Month;

import java.util.*;

public class Cinema {
    private Map<Integer, Set<Film>> films = new LinkedHashMap<>();

    public Cinema(Map<Integer, Set<Film>> films) {
        this.films = films;
    }

    public void addFilm (Film film) {
        Set<Film> movies = new LinkedHashSet<>();
        movies.add(film);
        films.put(film.getYear(), movies);
    }

    public Set<Film> getFilmsByYear(int year) {
        System.out.println("Список фильмов за " + year + " год: ");
        return films.get(year);
    }

    public Set<Film> getFilmsByYearAndMonth(int year, Month month) {
        Set<Film> filmsByYearAndMonth = films.get(year);
        Set<Film> filmsByMonth = new LinkedHashSet<>();
        for (Film film : filmsByYearAndMonth) {
            if (film.getMonth() == month) {
                filmsByMonth.add(film);
            }
        }
        System.out.println("Список фильмов за " + month + " " + year + " года: ");
        return filmsByMonth;
    }

    public Set<Film> getFilmsByGenre(Genre genre) {
        Set<Film> filmsByGenre = new LinkedHashSet<>();
        for (Set<Film> value : films.values()) {
            if (value.iterator().next().getGenre() == genre) {
                filmsByGenre.add(value.iterator().next());
            }
        }
        System.out.println("Список фильмов жанра " + genre + ": ");
        return filmsByGenre;
    }


    @Override
    public String toString() {
        return "Cinema{ " +
                "films= " + "\n" + films +
                '}';
    }

    public Map<Integer, Set<Film>> getFilms() {
        return films;
    }

}
