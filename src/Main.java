import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Textanalyse");
        System.out.println("Bitte geben Sie den zu analysierenden Text ein:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        // Überprüfung ob Text eingegeben wurde
        if (text.isEmpty()) {
            System.out.println("Es wurde kein Text eingegeben.");
            return;
        }

        int konsonanten = 0;
        int vokale = 0;
        int satzzeichen = 0;
        int leerzeichen = 0;

        char[] vokalArray = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}; //Vokal Array
        char[] satzzeichenArray = {'.', ',', '!', '?', ';', ':', '-', '(', ')', '"'}; //Satzzeichen Array

        int laenge = text.length();

        for (int i = 0; i < laenge; i++) { //Läuft Array durch bis ans Ende
            char zeichen = text.charAt(i);

            if (istInArray(zeichen, vokalArray)) { //Wenn Vokal - Variable vokale erhöhen
                vokale++;
            }
            else if (Character.isWhitespace(zeichen)) { //Wenn Leerzeichen - Variable leerzeichen erhöhen
                leerzeichen++;
            }
            else if (istInArray(zeichen, satzzeichenArray)) { //Wenn Satzzeichen - Variable satzzeichen erhöhen
                satzzeichen++;
            }
            else if (Character.isLetter(zeichen)) { //Ansonsten ist eine Konsonante - Variable konsonanten erhöhen
                konsonanten++;
            }
        }
        System.out.println("Länge des Textes: " + laenge);
        System.out.println("Anzahl der Vokale: " + vokale);
        System.out.println("Anzahl der Konsonanten: " + konsonanten);
        System.out.println("Anzahl der Satzzeichen: " + satzzeichen);
        System.out.println("Anzahl der Leerzeichen: " + leerzeichen);
    }

    public static boolean istInArray(char zeichen, char[] array) {
        // Durchlaufe jedes Zeichen im Array
        for (char element : array) {
            // Vergleiche, ob das aktuelle Zeichen mit dem gesuchten Zeichen übereinstimmt
            if (zeichen == element) {
                return true; // Zeichen gefunden
            }
        }
        return false; // Zeichen nicht gefunden
    }
}