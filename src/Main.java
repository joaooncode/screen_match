import domain.entities.Movie;
import domain.entities.Series;
import resources.TerminalColor;

import java.io.IOException;
import java.util.ArrayList;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


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

        Movie godfather = new Movie(
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

        Series flash = new Series(
                "The Flash",
                "Super-Herói",
                2014,
                userRating,
                "Depois de ser atingido por um raio, Barry Allen acorda de seu coma para descobrir que recebeu o poder da super velocidade, tornando se em Flash e lutando contra o crime na cidade.",
                "Greg Berlanti",
                new String[]{" Grant Gustin", "Candice Patton", "Danielle Panabaker"},
                true,
                9,
                184,
                42,
                true
        );

        System.out.println(TerminalColor.BLUE_BOLD + godfather + TerminalColor.RESET);

        Scanner scanner = new Scanner(System.in);

        godfather.displayMenu(scanner);
    }
}
