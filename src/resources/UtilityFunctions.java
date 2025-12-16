package resources;

import java.time.Duration;
import java.util.Scanner;

public class UtilityFunctions {

    public static int readOption(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Opção inválida. Digite um número");
        }
        return scanner.nextInt();
    }

    public static String FormatMinutesToHours(int minutes) {
        return Duration.ofMinutes(minutes).toString().replace("PT", "").replace("H", " horas e ").replace("M", " minutos.");
    }
}
