package ba.unsa.etf.rpr.tutorijal02;

public class Interval extends Object {
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
        if((this.getPocetna_tacka() < tacka || (this.getPocetna_tacka() == tacka && this.isUkljucena_prva() == true)) && (this.getKrajnja_tacka() > tacka || (this.getKrajnja_tacka() == tacka && this.isUkljucena_druga() == true)))
            return true;
        return false;
    }
    public Interval intersect(Interval i) {
        Interval vrati = new Interval();
        if(this.getPocetna_tacka() >= i.getPocetna_tacka() && this.getPocetna_tacka() <= i.getKrajnja_tacka()) {
            if(this.isUkljucena_prva() == true)
                vrati.setUkljucena_prva(true);
            else
                vrati.setUkljucena_prva(false);
            vrati.setPocetna_tacka(this.getPocetna_tacka());
        }
        else if(this.getPocetna_tacka() <= i.getPocetna_tacka() && this.getKrajnja_tacka() >= i.getPocetna_tacka()) {
            if(i.isUkljucena_prva() == true)
                vrati.setUkljucena_prva(true);
            else
                vrati.setUkljucena_prva(false);
            vrati.setPocetna_tacka(i.getPocetna_tacka());
        }
        if(this.getKrajnja_tacka() <= i.getKrajnja_tacka() && this.getKrajnja_tacka() >= i.getPocetna_tacka()) {
            if(this.isUkljucena_druga() == true)
                vrati.setUkljucena_druga(true);
            else
                vrati.setUkljucena_druga(false);
            vrati.setKrajnja_tacka(this.getKrajnja_tacka());
        }
        else if(this.getKrajnja_tacka() >= i.getKrajnja_tacka() && this.getPocetna_tacka() <= i.getKrajnja_tacka()) {
            if(i.isUkljucena_druga() == true)
                vrati.setUkljucena_druga(true);
            else
                vrati.setUkljucena_druga(false);
            vrati.setKrajnja_tacka(i.getKrajnja_tacka());
        }
        return vrati;
    }
    public String toString() {
        if(this.isNull()) {
            return "()";
        }
        String s = new String("");
        if(this.isUkljucena_prva())
            s+='[';
        else
            s+='(';
        s+=Double.toString(this.getPocetna_tacka()) + ',' + Double.toString(this.getKrajnja_tacka());
        if(this.isUkljucena_druga())
            s+=']';
        else
            s+=')';
        return s;
    }
    public static Interval intersect(Interval i1, Interval i2) {
        return i1.intersect(i2);
    }
    public boolean equals(Interval i) {
        if(this.getPocetna_tacka() == i.getPocetna_tacka() && this.getKrajnja_tacka() == i.getKrajnja_tacka() && this.isUkljucena_prva() == i.isUkljucena_prva() && this.isUkljucena_druga() == i.isUkljucena_druga())
            return true;
        return false;
    }
}
