package Collections.homework.collectionCinemaHomework.CinemaTask;

import Collections.homework.collectionCinemaHomework.enums.Genre;
import Collections.homework.collectionCinemaHomework.enums.Month;

import java.util.Objects;

public class Film {
    private int id;
    private int year;
    private Month month;
    private Genre genre;
    private double rating;

    public Film(int id, int year, Month month, Genre genre, double rating) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                year == film.year &&
                Double.compare(film.rating, rating) == 0 &&
                month == film.month &&
                genre == film.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, genre, rating);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
