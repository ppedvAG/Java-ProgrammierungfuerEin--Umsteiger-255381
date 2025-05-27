package packageJavaGrundkurs.Fahrzeugpark;

//Schiff erbt von der Fahrzeug-Klasse und übernimmt deren Member
public class Schiff extends Fahrzeug {

    //Klasseneigener Enum
    public enum SchiffsTreibstoff {Diesel, Dampf, Wind, Muskelkraft}

    //Klasseneigene Property
    SchiffsTreibstoff treibstoff;

    public SchiffsTreibstoff getTreibstoff() {
        return treibstoff;
    }

    public void setTreibstoff(SchiffsTreibstoff treibstoff) {
        this.treibstoff = treibstoff;
    }


    //Konstruktor mit Bezug auf den Konstruktor der Mutterklasse Fahrzeug
    public Schiff(String name) {
        super(name);
    }

    //Konstruktor mit einem zusätzlichen Parameter und Bezug auf die Mutterklasse
    public Schiff(String name, int maxG, double preis, SchiffsTreibstoff treibstoff) {
        super(name, maxG, preis);
        this.treibstoff = treibstoff;
    }

    //Überxchreibung der Info()-Methode mit Bezug auf die Methode der Mutterklasse (base)
    @Override
    public String Info() {
        return "Das Schiff " + super.Info() + " Es fährt mit " + this.treibstoff + ".";
    }

    @Override
    public void Hupen() {
        System.out.println("Das Schiff " + this.Name + " hupt!");
    }
}
