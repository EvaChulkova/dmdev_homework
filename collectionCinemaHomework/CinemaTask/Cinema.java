package Collections.homework.collectionCinemaHomework.CinemaTask;

import Collections.homework.collectionCinemaHomework.enums.Genre;
import Collections.homework.collectionCinemaHomework.enums.Month;

import java.util.*;

public class Cinema {
    private final Map<Integer, LinkedHashSet<Film>> films;


    public Cinema(Map<Integer, LinkedHashSet<Film>> films) {
        this.films = films;
    }

    public void addFilm (Film film) {
        if (films.containsKey(film.getYear())) {
            films.get(film.getYear()).add(film);
        } else {
            LinkedHashSet<Film> movies = new LinkedHashSet<>();
            movies.add(film);
            films.put(film.getYear(), movies);
        }
    }

    public LinkedHashSet<Film> getFilmsByYear(int year) {
        return films.get(year);
    }

    public LinkedHashSet<Film> getFilmsByYearAndMonth(int year, Month month) {
        LinkedHashSet<Film> result = new LinkedHashSet<>();
        for (Film film : films.get(year)) {
            if(film.getMonth() == month) {
                result.add(film);
            }
        }
        return result;
    }

    public void getFilmsByGenre(Genre genre) {
        for (LinkedHashSet<Film> value : films.values()) {
            if(value.iterator().next().getGenre() == genre) {
                System.out.println(value.iterator().next());
            }
        }
    }

    /*
    public List<Film> getTop10Films(int amountOfTopFilms) {
        List top10 = new ArrayList<>(amountOfTopFilms);
        for (Map.Entry<Integer, LinkedHashSet<Film>> entry : films.entrySet()) {
            for (Film film : entry.getValue()) {
                top10.add(film);
                top10.sort(new RatingComparator());
            }
        }
        return top10;
    }

     */

    public List<Film> getTop10Films() {
        List allFilms = new ArrayList<>(films.entrySet().size());
        List top10 = new ArrayList<>(10);
        for (Map.Entry<Integer, LinkedHashSet<Film>> entry : films.entrySet()) {
            for (Film film : entry.getValue()) {
                allFilms.add(film);
                for (int i = 0; i < 10; i++) {
                    top10.add(allFilms);
                }
            }
        }
        top10.sort(new RatingComparator());
        return top10;
    }

    @Override
    public String toString() {
        return "Cinema{ " +
                "films= " + "\n" + films +
                '}';
    }

    public Map<Integer, LinkedHashSet<Film>> getFilms() {
        return films;
    }

}
