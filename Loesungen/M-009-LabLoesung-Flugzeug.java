package packageJavaGrundkurs.Fahrzeugpark;

//vgl. Schiff
public class Flugzeug extends Fahrzeug {
    public int maxFlughoehe;

    public int getMaxFlughoehe() {
        return maxFlughoehe;
    }

    public void setMaxFlughoehe(int maxFlughoehe) {
        this.maxFlughoehe = maxFlughoehe;
    }

    public Flugzeug(String name, int maxG, double preis, int maxFH) {
        super(name, maxG, preis);
        this.maxFlughoehe = maxFH;
    }

    public Flugzeug(String name) {
        super(name);
    }

    @Override
    public String Info() {
        return "Das Flugzeug " + super.Info() + " Es kann bis auf " + this.maxFlughoehe + "m aufsteigen.";
    }

    @Override
    public void Hupen() {
        System.out.println("Das Flugzeug " + this.Name + " hupt!");
    }
}