package emberekoop;

import java.time.LocalDateTime;

public class Ember {

    //adattagok
    private String nev;
    private String szulDatum;
    private String szulHely;
    
    //Osztály metódusok
    
    //Konstruktor
    public Ember(){ //default konstruktor
    }
    //"Kis Géza";"1978-12-03";"Budapest"    
    public Ember(String adatSor){
        String[] adatok = adatSor.split(";");
        
        this.nev = adatok[0];
        this.szulDatum = adatok[1];
        this.szulHely = adatok[2];
    }
    
    public Ember(String nev, String szulDatum, String szulHely){
        this.nev = nev;
        this.szulDatum = szulDatum;
        this.szulHely = szulHely;
    }
    
    public int szuletesiEv(){
        return Integer.parseInt(this.szulDatum.substring(0, 4));
    }

    public int szuletesiHonap(){
        String[] adatok = this.szulDatum.split("-");
        return Integer.parseInt(adatok[1]);
    }

    public int szuletesiNap(){
        String[] adatok = this.szulDatum.split("-");
        return Integer.parseInt(adatok[2]);
    }

    public int eletKor(){
        return LocalDateTime.now().getYear() - this.szuletesiEv();
    }
        
    public String vezetekNev(){
        String[] nev = this.nev.split(" ");
        return nev[0];
    }
    
    public String keresztNev(){
        String[] nev = this.nev.split(" ");
        return nev[1];
    }
    
    public String teljesNev(){
        String nev = this.nev;
        return nev;
    }
    
    public String monogram(){
        String s;
        char v, k;
        String[] nev = this.nev.split(" ");
        v = nev[0].charAt(0);
        k = nev[1].charAt(0);
        s = v + ". " + k + ".";
        return s;
    }
    
    @Override
    public String toString(){
        return String.format("%-25s %-10s %-20s", this.nev, this.szulDatum, this.szulHely);
    }
    
    
}
