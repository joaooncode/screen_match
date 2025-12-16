package domain.entities;

import java.util.ArrayList;

public class Movie extends Title {
    public Movie(String title, String genre, int releaseYear, ArrayList<Double> userRating, int duration, String synopsis, String director, String[] actors, boolean isIncludedPlan) {
        super(title, genre, releaseYear, userRating, duration, synopsis, director, actors, isIncludedPlan);
    }
}
