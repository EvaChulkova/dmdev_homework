package Collections.homework.collectionCinemaHomework.CinemaTask;

import java.util.Comparator;

public class RatingComparator implements Comparator<Film> {

    @Override
    public int compare(Film o1, Film o2) {
        return Double.compare(o2.getRating(), o1.getRating());
    }
}
