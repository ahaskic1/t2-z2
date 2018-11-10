package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna_tacka, krajnja_tacka;
    private boolean ukljucena_prva, ukljucena_druga;

    public Interval(double pocetna_tacka, double krajnja_tacka, boolean ukljucena_prva, boolean ukljucena_druga) {
        if(pocetna_tacka > krajnja_tacka)   throw new IllegalArgumentException("Nemoguc interval");
        this.pocetna_tacka = pocetna_tacka;
        this.krajnja_tacka = krajnja_tacka;
        this.ukljucena_prva = ukljucena_prva;
        this.ukljucena_druga = ukljucena_druga;
    }
    public Interval() {
        this.pocetna_tacka = 0;
        this.krajnja_tacka = 0;
        this.ukljucena_prva = false;
        this.ukljucena_druga = false;
    }
    public double getPocetna_tacka() {
        return this.pocetna_tacka;
    }
    public double getKrajnja_tacka() {
        return this.krajnja_tacka;
    }
    public boolean isUkljucena_prva() {
        return this.ukljucena_prva;
    }
    public boolean isUkljucena_druga() {
        return this.ukljucena_druga;
    }
    public void setPocetna_tacka(double pocetna_tacka) {
        this.pocetna_tacka = pocetna_tacka;
    }
    public void setKrajnja_tacka(double krajnja_tacka) {
        this.krajnja_tacka = krajnja_tacka;
    }
    public void setUkljucena_prva(boolean ukljucena_prva) {
        this.ukljucena_prva = ukljucena_prva;
    }
    public void setUkljucena_druga(boolean ukljucena_druga) {
        this.ukljucena_druga = ukljucena_druga;
    }
    public boolean isNull() {
        if(this.getPocetna_tacka() == 0 && this.getKrajnja_tacka() == 0 && this.isUkljucena_prva() == false && this.isUkljucena_druga() == false) {
            return true;
        }
        return false;
    }
    public boolean isIn(double tacka) {
        if((this.getPocetna_tacka() < tacka || (this.getPocetna_tacka() == tacka && this.isUkljucena_prva()== true)) && (this.getKrajnja_tacka() > tacka || (this.getKrajnja_tacka() == tacka && this.isUkljucena_druga() == true)))
            return true;
        return false;
    }


}
