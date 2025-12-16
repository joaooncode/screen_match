package domain.entities;

import domain.exceptions.InvalidRatingException;
import resources.TerminalColor;
import resources.UtilityFunctions;

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
        return String.format("%s (%d) %s", title, releaseYear, getIsIncludedPlan());
    }

    //Métodos
    public String getIsIncludedPlan() {
        return isIncludedPlan ? TerminalColor.GREEN + "[Incluído no plano]" + TerminalColor.RESET : TerminalColor.RED + "[Não incluído no plano]" + TerminalColor.RESET;
    }

    public void setUserRating() {
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

    public void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("""
                    
                    Menu do filme
                    [1] Exibir ficha técnica
                    [2] Avaliar filme
                    """);

            int option = UtilityFunctions.readOption(scanner);

            switch (option) {
                case 1:
                    displayMovieInformation();
                    break;
                case 2:
                    setUserRating();
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void displayMovieInformation() {
        System.out.printf("""
                Ficha técnica completa do filme %s:
                
                Titulo: %s
                Ano de Lançamento: %d
                Gênero: %s
                Diretor: %s
                Sinopse: %s
                
                Atores:
                %s
                
                Avaliação média do filme: %s
                Duração do filme: %s
                
                """, title, title, releaseYear, genre, director, synopsis, this.getActors(), getAverageRating(), getDuration());
    }

    // Getters
    public String getActors() {
        if (actors == null || actors.length == 0) {
            return "(sem atores cadastrados)";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < actors.length; i++) {
            sb.append(i + 1).append(" - ").append(actors[i]).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


    public String getDuration() {
        return UtilityFunctions.FormatMinutesToHours(duration);
    }

    public String getAverageRating() {
        if (userRating == null || userRating.isEmpty()) {
            System.out.println("O filme ainda não foi avaliado.");
            return null;
        }

        double sum = 0;
        for (double rating : userRating) {
            sum += rating;
        }

        double averageRating = sum / userRating.size();
        return String.format("%.2f", averageRating);
    }
}
