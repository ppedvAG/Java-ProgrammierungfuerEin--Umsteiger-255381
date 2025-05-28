package modul6;

public class modul6 {
    int feld1;
    int feld2;

    public modul6(int feld1) {
        feld1 = feld1;
    }

    public modul6(int feld1, int feld2) {
        this.feld1 = feld1;
        this.feld2 = feld2;
    }

    public int getFeld1() {
        return feld1;
    }

    public void setFeld1(int feld1) {
        this.feld1 = feld1;
    }

    public int getFeld2() {
        return feld2;
    }

    public void setFeld2(int feld2) {
        this.feld2 = feld2;
    }
}
