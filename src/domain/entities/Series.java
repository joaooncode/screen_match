package domain.entities;

import java.util.ArrayList;

public class Series extends Title {

    private int seasons;
    private int episodes;
    private int averageMinutesPerEpisode; // Média de minutos por episódio
    private boolean isActive;

    public Series(String title,
                  String genre,
                  int releaseYear,
                  ArrayList<Double> userRating,
                  int duration,
                  String synopsis,
                  String director,
                  String[] actors,
                  boolean isIncludedPlan,
                  int seasons,
                  int episodes,
                  int averageMinutesPerEpisode,
                  boolean isActive
    ) {
        super(title, genre, releaseYear, userRating, duration, synopsis, director, actors, isIncludedPlan);
        this.seasons = seasons;
        this.episodes = episodes;
        this.averageMinutesPerEpisode = averageMinutesPerEpisode;
        this.isActive = isActive;
    }

    // Segundo construtor da classe Series, sem o atributo 'duration'
    public Series(
            String title,
            String genre,
            int releaseYear,
            ArrayList<Double> userRating,
            String synopsis,
            String director,
            String[] actors,
            boolean isIncludedPlan,
            int seasons,
            int episodes,
            int averageMinutesPerEpisode,
            boolean isActive
    ){
        super(title, genre, releaseYear, userRating, synopsis, director, actors, isIncludedPlan);
        this.seasons = seasons;
        this.episodes = episodes;
        this.averageMinutesPerEpisode = averageMinutesPerEpisode;
        this.isActive = isActive;
    }
}
