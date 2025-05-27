package Fahrzeugpark;

public class Fahrzeug
{
    //Properties
    public String Name;
    public int MaxGeschwindigkeit;
    public int AktGeschwindigkeit;
    public double Preis;
    public boolean MotorLaeuft;

    //Getter and Setter
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getMaxGeschwindigkeit() {
        return MaxGeschwindigkeit;
    }
    public void setMaxGeschwindigkeit(int maxGeschwindigkeit) {
        MaxGeschwindigkeit = maxGeschwindigkeit;
    }
    public int getAktGeschwindigkeit() {
        return AktGeschwindigkeit;
    }
    public void setAktGeschwindigkeit(int aktGeschwindigkeit) {
        AktGeschwindigkeit = aktGeschwindigkeit;
    }
    public double getPreis() {
        return Preis;
    }
    public void setPreis(double preis) {
        Preis = preis;
    }
    public boolean isMotorLaeuft() {
        return MotorLaeuft;
    }
    public void setMotorLaeuft(boolean motorLaeuft) {
        MotorLaeuft = motorLaeuft;
    }

    //Konstruktor mit Übergabeparametern und Standartwerten
    public Fahrzeug(String name, int maxG, double preis)
    {
        this.Name = name;
        this.MaxGeschwindigkeit = maxG;
        this.Preis = preis;
        this.AktGeschwindigkeit = 0;
        this.MotorLaeuft = false;
    }

    //Methode zur Ausgabe von Objektinformationen
    public String Info()
    {
        if (this.MotorLaeuft)
            return this.Name+" kostet "+this.Preis+"€ und fährt momentan mit "+this.AktGeschwindigkeit+" von maximal "+this.MaxGeschwindigkeit+"km/h.";
        else
            return this.Name+" kostet "+this.Preis+"€ und könnte maximal "+this.MaxGeschwindigkeit+"km/h fahren.";
    }

    //Methode zum Starten des Motors
    public void StarteMotor()
    {
        if (this.MotorLaeuft)
            System.out.println("Der Motor von "+this.Name+" läuft bereits.");
        else
        {
            this.MotorLaeuft = true;
            System.out.println("Der Motor von "+this.Name+" wurde gestartet.");
        }
    }

    //Methode zum Stoppen des Motors
    public void StoppeMotor()
    {
        if (!this.MotorLaeuft)
            System.out.println("Der Motor ist bereits gestoppt");
        else if (this.AktGeschwindigkeit > 0)
            System.out.println("Der Motor kann nicht gestoppt werden, da sich "+this.Name+" noch bewegt");
        else
        {
            this.MotorLaeuft = false;
            System.out.println("Der Motor wurde gestoppt.");
        }
    }

    //Methode zum Beschleunigen und Bremsen
    public void Beschleunige(int a)
    {
        if (this.MotorLaeuft)
        {
            if (this.AktGeschwindigkeit + a > this.MaxGeschwindigkeit)
                this.AktGeschwindigkeit = this.MaxGeschwindigkeit;
            else if (this.AktGeschwindigkeit + a < 0)
                this.AktGeschwindigkeit = 0;
            else
                this.AktGeschwindigkeit += a;

            System.out.println(this.Name+" bewegt sich jetzt mit "+this.AktGeschwindigkeit+"km/h");
        }
    }

}

//Schiff erbt von der Fahrzeug-Klasse und übernimmt deren Member
class Schiff extends Fahrzeug
{
    //Klasseneigener Enum
    public enum SchiffsTreibstoff { Diesel, Dampf, Wind, Muskelkraft }

    //Klasseneigene Property
    SchiffsTreibstoff treibstoff;

    public SchiffsTreibstoff getTreibstoff() {
        return treibstoff;
    }

    public void setTreibstoff(SchiffsTreibstoff treibstoff) {
        this.treibstoff = treibstoff;
    }

    //Konstruktor mit Bezug auf den Konstruktor der Mutterklasse (base)
    public Schiff(String name, int maxG, double preis, SchiffsTreibstoff treibstoff)
    {
        super(name, maxG, preis);
        this.treibstoff = treibstoff;
    }

    //Überxchreibung der Info()-Methode mit Bezug auf die Methode der Mutterklasse (base)
    @Override
    public String Info()
    {
        return "Das Schiff " + super.Info() + " Es fährt mit "+this.treibstoff+".";
    }
}

//vgl. Schiff
class PKW extends Fahrzeug
{
    public int anzahlTueren;

    public int getAnzahlTueren() {
        return anzahlTueren;
    }

    public void setAnzahlTueren(int anzahlTueren) {
        this.anzahlTueren = anzahlTueren;
    }

    public PKW(String name, int maxG, double preis, int anzTueren) 
    {
        super(name, maxG, preis);
        this.anzahlTueren = anzTueren;
    }

    @Override
    public String Info()
    {
        return "Der PKW " + super.Info() + " Er hat "+ this.anzahlTueren+" Türen.";
    }
}

//vgl. Schiff
class Flugzeug extends Fahrzeug
{
    public int maxFlughoehe;

    public int getMaxFlughoehe() {
        return maxFlughoehe;
    }

    public void setMaxFlughoehe(int maxFlughoehe) {
        this.maxFlughoehe = maxFlughoehe;
    }

    public Flugzeug(String name, int maxG, double preis, int maxFH)
    {
        super(name, maxG, preis);
        this.maxFlughoehe = maxFH;
    }

    @Override
    public String Info()
    {
        return "Das Flugzeug " + super.Info() + " Es kann bis auf "+this.maxFlughoehe+"m aufsteigen.";
    }
}

class Program
{
    public static void main(String[] args)
    {
        //Instanziierung verschiedener Fahrzeuge
        PKW pkw1 = new PKW("Mercedes", 210, 23000, 5);
        Schiff schiff1 = new Schiff("Titanic", 40, 25000000, Schiff.SchiffsTreibstoff.Dampf);
        Flugzeug flugzeug1 = new Flugzeug("Boing", 350, 90000000, 9800);

        //Ausgabe der verschiedenen Info()-Methoden
        System.out.println(pkw1.Info());
        System.out.println(schiff1.Info());
        System.out.println(flugzeug1.Info());



    }
}