
package packageJavaGrundkurs;

import packageJavaGrundkurs.Fahrzeugpark.Fahrzeug;
import packageJavaGrundkurs.Fahrzeugpark.Schiff;

public class Main {
    public static void main(String[] args) {
        Fahrzeug[] fahrzeuge = new Fahrzeug[10];
        int anzSchiffe = 0;
        int anzPKWs = 0;
        int anzFlugzeuge = 0;
        for (int i = 0; i < fahrzeuge.length; i++) {
            fahrzeuge[i] = Fahrzeug.GeneriereFahrzeug("Fahrzeug" + (i + 1));
            System.out.println(fahrzeuge[i].Info());
            if (fahrzeuge[i].getClass() == Schiff.class) {

            }
            switch (fahrzeuge[i].getClass().getName()) {
                case "packageJavaGrundkurs.Fahrzeugpark.Schiff":
                    anzSchiffe++;
                    break;
                case "packageJavaGrundkurs.Fahrzeugpark.PKW":
                    anzPKWs++;
                    break;
                case "packageJavaGrundkurs.Fahrzeugpark.Flugzeug":
                    anzFlugzeuge++;
                    break;
                default:
                    System.out.println("Switch fehlgeschlagen: " + fahrzeuge[i].getClass().getName());
            }
        }
        System.out.println("\n\nFlugzeuge: " + anzFlugzeuge);
        System.out.println("PKWs: " + anzPKWs);
        System.out.println("Schiffe: " + anzSchiffe);
        System.out.println("\n\n");
        fahrzeuge[2].Hupen();
    }
}
