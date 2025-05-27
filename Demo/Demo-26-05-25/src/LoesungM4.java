import java.util.Scanner;


public class LoesungM4 {

    public static void main(String[] args) {

        //Enum-Definition
        enum Rechenoperation {
            // 4 mögliche Werte, die das Enum annehmen kann
            ADDITION(1, "Addition"),
            SUBTRAKTION(2, "Subtraktion"),
            MULTIPLIKATION(3, "Multiplikation"),
            DIVISION(4, "Division");

            // Variablen des Enum
            // für Zugriff auf id und description des Enum
            private final int id;
            private final String description;

            // Konstruktor
            Rechenoperation(int id, String description) {
                this.id = id;
                this.description = description;
            }

            // Get Methoden
            public int getId() {
                return id;
            }

            public String getDescription() {
                return description;
            }
        }

        //Scanner für spätere User Eingaben
        Scanner scanner = new Scanner(System.in);

        //Schleife für Programm-Wiederholung
        String wiederholen = "";
        do {
            double zahl1, zahl2;
            Rechenoperation auswahl;
            //Aufforderung die erste Zahl einzugeben
            System.out.print("\nGib eine Zahl ein: ");
            //Überprüfung, ob der User eine gültige Zahl eingegeben hat
            if (scanner.hasNextDouble()) {
                //Eingegebene Zahl in Variable zahl1 Speichern
                zahl1 = scanner.nextDouble();
            } else {
                System.out.println("Bitte eine gültige Zahl eingeben\n");
                //Schleife wird von vorne gestartet
                continue;
            }

            //Eingabe der zweiten Zahl
            System.out.print("Gib eine weitere Zahl ein: ");
            if (scanner.hasNextDouble()) {
                zahl2 = scanner.nextDouble();
            } else {
                System.out.println("Bitte eine gültige Zahl eingeben\n");
                continue;
            }


            System.out.println("\nWähle eine Rechenoperation:");
            //Anzeige der möglichen Rechenoperationen
            for (Rechenoperation op : Rechenoperation.values()) {
                //Ausgabe der id (int) und der description (String) der jeweiligen Rechenoperation
                System.out.println(op.getId() + ": " + op.getDescription());
            }

            //Abfrage der Benutzereingabe
            System.out.print("Auswahl: ");
            scanner.nextLine();
            if (scanner.hasNextLine()) {
                //Usereingabe wird in Variable eingabe gespeichert
                String eingabe = scanner.nextLine();
                //eingabe wird zu Großbuchstaben konvertiert
                eingabe = eingabe.toUpperCase();
                //es wird die jeweilige Rechenoperation, die eingegeben wurde, in auswahl gespeichert
                auswahl = Rechenoperation.valueOf(eingabe);
            } else {
                System.out.println("Bitte eine gültige Rechenoperation eingeben\n");
                continue;
            }


            //Deklaration und Initialisierung der Ergebnisvariablen
            double ergebnis = 0.0;

            //Switch zur Auswahl der Rechenoperation
            switch (auswahl) {
                //Berechnung des Ergebnisses
                case ADDITION:
                    ergebnis = zahl1 + zahl2;
                    break;
                case SUBTRAKTION:
                    ergebnis = zahl1 - zahl2;
                    break;
                case MULTIPLIKATION:
                    ergebnis = zahl1 * zahl2;
                    break;
                case DIVISION:
                    //Prüfung einer möglichen Teilung durch null
                    if (zahl2 == 0) {
                        System.out.println("\nEine Division durch 0 ist nicht erlaubt.");
                        //Sprung zur Schleifenprüfung
                        continue;
                    }
                    ergebnis = zahl1 / zahl2;
                    break;
                default:
                    //Fall, welcher eintrofft, wenn keine valide Rechenoperation ausgewählt wurde
                    System.out.println("\nBitte eine gültige Rechenoperation eingeben\n");
                    continue;

            }

            //Ausgabe des Ergebnisses
            System.out.println("\nErgebnis: " + ergebnis);

            //Frage nach der Wiederholung des Programms
            System.out.println("Wiederholen? (j/n) ");
            wiederholen = "";
            // Schleife um auf die Antwort des Benutzers zu warten
            while (wiederholen.isEmpty()) {
                wiederholen = scanner.nextLine();
            }

            //Die Schleife wird wiederholt, wenn der benutzer j oder J eingegeben hat
        } while (wiederholen.equalsIgnoreCase("j"));
    }
}