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
        LinkedHashSet<Film> movies = new LinkedHashSet<>();
        movies.add(film);
        if (films.containsKey(film.getYear())) {
            films.get(film.getYear()).add(film);
        } else {
            films.put(film.getYear(), movies);
        }
    }

    public void getFilmsByYear(int year) {
        for (Map.Entry<Integer, LinkedHashSet<Film>> entry : films.entrySet()) {
            if(entry.getKey() == year){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public void getFilmsByYearAndMonth(int year, Month month) {
        for (Map.Entry<Integer, LinkedHashSet<Film>> entry : films.entrySet()) {
            if (entry.getKey() == year) {
                for (Film film : entry.getValue()) {
                    if(film.getMonth() == month) {
                        System.out.println(film);
                    }
                }
            }
        }
    }

    public void getFilmsByGenre(Genre genre) {
        for (LinkedHashSet<Film> value : films.values()) {
            if(value.iterator().next().getGenre() == genre) {
                System.out.println(value.iterator().next());
            }
        }
    }

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
