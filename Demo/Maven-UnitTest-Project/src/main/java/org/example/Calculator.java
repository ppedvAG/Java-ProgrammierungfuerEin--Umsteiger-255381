package org.example;

import java.util.Scanner;

public class Calculator {
    //Enum-Definition
    public enum Rechenoperation {
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

    //Methode GetInput (bekommt text und gibt double zurück)
    static double GetInput(String text)
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {   //text ausgeben
            System.out.print(text);
            if (scanner.hasNextDouble()) { // Prüfen, ob die Eingabe eine Zahl ist
                //eingegebene Zahl zurückgeben
                return scanner.nextDouble();
            }
        }
    }

    //Methode GetRechenoperation (gibt Rechenoperation aus Eingabe zurück)
    static Rechenoperation GetRechenoperation()
    {
        Scanner scanner = new Scanner(System.in);
        Rechenoperation operation = null;
        boolean funktioniert = false;

        //solange ausführen, bis eine gültige Rechenoperation eingegeben wurde
        while (!funktioniert) {
            //zeile von Console einlesen
            String eingabe = scanner.nextLine();

            try {
                // eingabe wird in Enum umgewandelt (.toUpperCase ändert die eingabe zu Großbuchstaben)
                operation = Rechenoperation.valueOf(eingabe.toUpperCase());
                funktioniert = true;

                //Wenn die Umwandlung einen Fehler wirft, wird der code
                //in try{} abgebrochen und der code in catch(){} ausgeführt
            } catch (IllegalArgumentException e) {
                System.out.println("Keine gültige Rechenoperation ausgewählt.");
            }
        }

        //Rechenoperation wird zurückgegeben
        return operation;
    }

    //Methode Berechne (bekommt x, y und rechenoperation und gibt double zurück)
    public static double Berechne(double x, double y, Rechenoperation rechenoperation)
    {
        //switch über rechenoperation, gibt das jeweilige ergebnis als double zurück
        switch (rechenoperation)
        {
            case Rechenoperation.ADDITION:
                return x + y;
            case Rechenoperation.SUBTRAKTION:
                return x - y;
            case Rechenoperation.MULTIPLIKATION:
                return x * y;
            case Rechenoperation.DIVISION: {
                if(y!=0) { //wenn y nicht 0 ist, wird die division berechnet
                    return x/y;
                } else { //ansonsten wird "Not a Number" zurückgegeben
                    return Double.NaN;
                }
            }
            default:
                return Double.NaN;
        }
    }

    //Methode ConvertRechenoperation (bekommt rechenoperation und gibt String zurück)
    public static String ConvertRechenoperation(Rechenoperation rechenoperation)
    {
        //switch über rechenoperation, gibt das jeweilige rechensymbol als String zurück
        switch (rechenoperation)
        {
            case Rechenoperation.ADDITION:
                return "+";
            case Rechenoperation.SUBTRAKTION:
                return "-";
            case Rechenoperation.MULTIPLIKATION:
                return "*";
            case Rechenoperation.DIVISION:
                return "/";
            default:
                return "";
        }
    }
}
