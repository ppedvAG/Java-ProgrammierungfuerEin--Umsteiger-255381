import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//--Aufgabe 1------------------------------------------------------------------------------------------
        //Abfrage der Eingabe
        System.out.println("Gib das Jahr ein:");
        Scanner scanner = new Scanner(System.in);
        int eingabe = scanner.nextInt();

        //Deklarierung/Initialisierung der bool-Variablen
        boolean istSchaltjahr = false;

        //Prüfung einer Teilbarkeit durch 4
        if (eingabe % 4 == 0)
        {
            //Setzten der Variablen auf true
            istSchaltjahr = true;

            //Prüfung einer Teilbarkeit durch 100
            if (eingabe % 100 == 0)
            {
                //Setzten der Variablen auf false
                istSchaltjahr = false;

                //Prüfung einer Teilbarkeit durch 400
                if (eingabe % 400 == 0)
                    //Setzten der Variablen auf true
                    istSchaltjahr = true;
            }
        }

        //Ausgabe
        System.out.println(eingabe+" ist Schaltjahr: "+istSchaltjahr);

        //Alternative (detailiertere) Ausgabe mittels Kurz-Bedingung
        if(istSchaltjahr)
        {
            System.out.println(eingabe+" ist ein Schaltjahr");
        } else {
            System.out.println(eingabe+" ist kein Schaltjahr");
        }

        //ein paar zeilen Abstand
        System.out.println("\n\n\n");

//--Aufgabe 2------------------------------------------------------------------------------------------
        //Deklaration & Initialisierung des Arrays der Gewinnzahlen
        int[] gewinnzahlen = { 3, 16, 45, 79, 99 };

        //Abfrage des User-Tipps
        System.out.print("Bitte gib deinen Tipp ab (Ganzzahl zwischen 0 und 100): ");
        int tipp = scanner.nextInt();

        //Prüfung des Zahlenbereiches des Tipps
        if (tipp < 0 || tipp > 100)
            System.out.println("Dein Tipp ist außerhalb des Zahlenbereiches.");
        else {
            //Prüfung, ob Tipp eine Gewinnzahl ist und Ausgabe
            if (Arrays.asList(gewinnzahlen).contains(tipp))
                System.out.println("Glückwunsch!! Du hast eine der fünf Gewinnzahlen getippt.");
            else
                System.out.println("Leider daneben. Viel Glück beim nächsten Mal.");
        }
    }
}