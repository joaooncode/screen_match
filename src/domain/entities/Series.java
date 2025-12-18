package domain.entities;

import resources.UtilityFunctions;

import java.util.ArrayList;
import java.util.Scanner;

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

    @Override
    public void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("""
             
                    Menu da série
                    [1] Exibir ficha técnica
                    [2] Avaliar Série
                    [3] Adicionar temporadas
                    [4] Sair
                    """);

            int option = UtilityFunctions.readOption(scanner);

            switch (option) {
                case 1:
                    displayTitleInformation();
                    break;
                case 2:
                    setUserRating();
                    break;
                case 3:
                    System.out.println("Digite a quantidade de temporadas a serem adicionadas: ");
                    setSeasons(UtilityFunctions.readOption(scanner));
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    @Override
    public void displayTitleInformation() {
        System.out.printf("""
                Ficha técnica completa do título %s:
                
                Titulo: %s
                Ano de Lançamento: %d
                Gênero: %s
                Diretor: %s
                Sinopse: %s
                Temporadas: %d,
                Episódios: %d
                
                Atores:
                %s
               
                Avaliação média do título: %s
                
                """, title, title, releaseYear, genre, director, synopsis, seasons, episodes, this.getActors(), getAverageRating());
    }

    public void setSeasons(int seasons){
        this.seasons += seasons;
        System.out.printf("Temporadas adicionadas com sucesso!\nTotal de temporadas: %d", this.seasons);
    }
}
