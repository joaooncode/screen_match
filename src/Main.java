import domain.entities.Movie;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        System.out.println("Aplicação Screen Match");


        String[] actors =  {"Marlon Brando", "Al Pacino", "James Caan"};
        ArrayList<Double> userRating = new ArrayList<>();
        Movie movie = new Movie(
                "Godfather",
                "Criminal",
                1972,
                userRating,
                175,
                "O patriarca idoso de uma dinastia do crime organizado transfere o controle de seu império clandestino para seu filho relutante.",
                "Francis Ford Coppola",
                actors,
                true
        );


        System.out.println(movie);

        movie.setRating();
        movie.getAverageRating();
    }
}
