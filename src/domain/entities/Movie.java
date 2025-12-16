package domain.entities;

import domain.entities.exceptions.InvalidRatingException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Movie {

    //Atributos
    private String title;
    private String genre;
    private int releaseYear;
    private ArrayList<Double> userRating;
    private int duration;
    private String synopsis;
    private String director;
    private String[] actors;
    private boolean isIncludedPlan;

    //Construtor
    public Movie(String title, String genre, int releaseYear, ArrayList<Double> userRating, int duration, String synopsis, String director, String[] actors, boolean isIncludedPlan) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.userRating = (userRating == null) ? new ArrayList<>() : userRating;
        this.duration = duration;
        this.synopsis = synopsis;
        this.director = director;
        this.actors = actors;
        this.isIncludedPlan = isIncludedPlan;
    }

    //Representação em formato ‘String’ da entidade Movie
    public String toString() {
        return String.format("%s (%d) %s %s", title, releaseYear, Duration.ofMinutes(duration), getIsIncludedPlan());
    }

    //Métodos
    public String getIsIncludedPlan() {
        return isIncludedPlan ? "Incluído no plano" : "Não incluído no plano";
    }

    public void setUserRatingRating() {
        System.out.println("Digite a nota do filme (0-10). Digite 'X' para finalizar a avaliação: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.printf("Digite a %dª nota do filme %s: ", userRating.size() + 1, title);

            String rating = scanner.nextLine().trim();
            if (rating.equalsIgnoreCase("X")) {
                System.out.printf("""
                        
                        Obrigado por avaliar o filme %s!
                        Avaliações inseridas: %s
                        """, title, userRating.toString());

                break;
            }

            try {
                double ratingValue = Double.parseDouble(rating);

                if (ratingValue < 0 || ratingValue > 10) {
                    throw new InvalidRatingException("A nota deve estar entre 0 e 10.");
                }
                userRating.add(ratingValue);
            } catch (InvalidRatingException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor digite um número entre 0 e 10.");
            }
        }
    }

    public void getAverageRating() {
        if (userRating == null || userRating.isEmpty()) {
            System.out.println("O filme ainda não foi avaliado.");
            return;
        }

        double sum = 0;
        for (double rating : userRating) {
            sum += rating;
        }

        double averageRating = (double) sum / userRating.size();

        System.out.printf("Média de avaliação do filme: %.2f", averageRating);

    }
}
