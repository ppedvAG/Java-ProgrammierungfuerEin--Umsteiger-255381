
package packageJavaGrundkurs;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Schleife -> 10 Fahrzeuge werden erzeugt
        for (int i = 1; i<=10; i++) {
            Fahrzeug fahrzeug = new Fahrzeug("Fahrzeug"+i, 30*i,i*5000.0);
        }
        //Anzahl der erzeugten Fahrzeuge wird ausgegeben
        System.out.println(Fahrzeug.GetAnzahlFahrzeugeString());
    }
}
