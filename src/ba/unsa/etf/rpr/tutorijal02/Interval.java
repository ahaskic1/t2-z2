package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetna_tacka, krajnja_tacka;
    boolean ukljucena_prva, ukljucena_druga;

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


}
