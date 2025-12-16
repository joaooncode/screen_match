import domain.entities.Movie;
import resources.TerminalColor;

import java.io.IOException;
import java.util.ArrayList;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {

        try {
            String banner = Files.readString(Path.of("src/resources/banner.txt"), StandardCharsets.UTF_8);
            System.out.println(TerminalColor.CYAN_BOLD + banner + TerminalColor.RESET);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String[] actors = {"Marlon Brando", "Al Pacino", "James Caan"};
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

        System.out.println(TerminalColor.BLUE_BOLD + movie + TerminalColor.RESET);

        movie.setUserRating();
        movie.getAverageRating();
    }
}
