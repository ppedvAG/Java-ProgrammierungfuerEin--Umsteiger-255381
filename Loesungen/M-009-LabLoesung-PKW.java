package packageJavaGrundkurs.Fahrzeugpark;

//vgl. Schiff
public class PKW extends Fahrzeug {
    public int anzahlTueren;

    public int getAnzahlTueren() {
        return anzahlTueren;
    }

    public void setAnzahlTueren(int anzahlTueren) {
        this.anzahlTueren = anzahlTueren;
    }

    public PKW(String name, int maxG, double preis, int anzTueren) {
        super(name, maxG, preis);
        this.anzahlTueren = anzTueren;
    }

    public PKW(String name) {
        super(name);
    }

    @Override
    public String Info() {
        return "Der PKW " + super.Info() + " Er hat " + this.anzahlTueren + " Türen.";
    }

    @Override
    public void Hupen() {
        System.out.println("Der PKW " + this.Name + " hupt!");
    }
}