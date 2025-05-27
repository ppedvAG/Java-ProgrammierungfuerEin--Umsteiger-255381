package packageJavaGrundkurs.Fahrzeugpark;

import java.util.Random;

public abstract class Fahrzeug {
    //Properties mit Standardwerten
    public String Name = "";
    public int MaxGeschwindigkeit = 0;
    public int AktGeschwindigkeit = 0;
    public double Preis = 0;
    public boolean MotorLaeuft = false;


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

    //Konstruktor mit Übergabeparametern
    public Fahrzeug(String name, int maxG, double preis) {
        this.Name = name;
        this.MaxGeschwindigkeit = maxG;
        this.Preis = preis;
    }

    //Konstruktor mit nur einem Übergabeparameter
    public Fahrzeug(String name) {
        this.Name = name;
    }


    //Methode zur Ausgabe von Objektinformationen
    public String Info() {
        if (this.MotorLaeuft)
            return this.Name + " kostet " + this.Preis + "€ und fährt momentan mit " + this.AktGeschwindigkeit + " von maximal " + this.MaxGeschwindigkeit + "km/h.";
        else
            return this.Name + " kostet " + this.Preis + "€ und könnte maximal " + this.MaxGeschwindigkeit + "km/h fahren.";
    }

    //Methode zum Starten des Motors
    public void StarteMotor() {
        if (this.MotorLaeuft)
            System.out.println("Der Motor von " + this.Name + " läuft bereits.");
        else {
            this.MotorLaeuft = true;
            System.out.println("Der Motor von " + this.Name + " wurde gestartet.");
        }
    }

    //Methode zum Stoppen des Motors
    public void StoppeMotor() {
        if (!this.MotorLaeuft)
            System.out.println("Der Motor ist bereits gestoppt");
        else if (this.AktGeschwindigkeit > 0)
            System.out.println("Der Motor kann nicht gestoppt werden, da sich " + this.Name + " noch bewegt");
        else {
            this.MotorLaeuft = false;
            System.out.println("Der Motor wurde gestoppt.");
        }
    }

    //Methode zum Beschleunigen und Bremsen
    public void Beschleunige(int a) {
        if (this.MotorLaeuft) {
            if (this.AktGeschwindigkeit + a > this.MaxGeschwindigkeit)
                this.AktGeschwindigkeit = this.MaxGeschwindigkeit;
            else if (this.AktGeschwindigkeit + a < 0)
                this.AktGeschwindigkeit = 0;
            else
                this.AktGeschwindigkeit += a;

            System.out.println(this.Name + " bewegt sich jetzt mit " + this.AktGeschwindigkeit + "km/h");
        }
    }

    //Abstrakte Methode Hupen (dazu muss der Modifier abstract zur Klasse Fahrzeug hinzugefügt werden)
    public abstract void Hupen();

    //Statische Methode GeneriereFahrzeug, gibt ein Objekt der Klasse Fahrzeug zurück
    public static Fahrzeug GeneriereFahrzeug(String name) {
        Random random = new Random();
        //random.nextInt generiert eine ganze Zahl (in diesem Fall von 1 bis 3)
        //in jedem case wird ein neues Fahrzeug (Schiff, PKW, oder Flugzeug) zurückgegeben
        Fahrzeug generiertesFahrzeug = null;
        switch (random.nextInt((3 - 1) + 1) + 1) {
            case 1:
                generiertesFahrzeug = new Schiff(name);
                break;
            case 2:
                generiertesFahrzeug = new PKW(name);
                break;
            case 3:
                generiertesFahrzeug = new Flugzeug(name);
                break;
        }
        return generiertesFahrzeug;
    }

    @Override
    public String toString() {
        return "Fahrzeugtyp: "+this.getClass()+ " Name: " + this.getName();
    }
}