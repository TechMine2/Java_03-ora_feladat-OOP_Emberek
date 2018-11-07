package emberekoop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Emberek {

    private List<Ember> emberekLista;
    
    public Emberek(){
        String[] nevek = {"Kis Géza", "Kolompár Endre", "Lakatos Krisztián", "Nagy Andor", "Lapos Elemér"};
        String[] szuletesiDatumok = {"1965-02-05","1967-05-02","1995-11-30","1983-12-15","1934-08-19"};
        String[] szuletesiHelyek = {"Budapest","Budapest","Debrecen","Szeged","Budapest"};

        this.emberekLista = new ArrayList<Ember>();
        for (int i = 0; i < nevek.length; i++) {
            this.emberekLista.add(
                    new Ember(
                            nevek[i],
                            szuletesiDatumok[i],
                            szuletesiHelyek[i])
            );
        }
    }

    public Emberek(String fajl){
        this.emberekLista = new ArrayList<Ember>();
        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);

            String sor = br.readLine();
            while (sor != null){ //AMIG NEM ÉRET A FÁJL VÉGÉRE
                this.emberekLista.add(new Ember(sor));
                sor = br.readLine();
            }
            
            br.close();
            fr.close();
        } catch (Exception ex ) {
            System.out.println("Hiba: " + ex);
        }
    }
    
    public int adottHonapbanSzuletettekSzama(int honap){
        int db = 0;
        for (int i = 0; i < this.emberekLista.size(); i++) {
            if (this.emberekLista.get(i).szuletesiHonap() == honap ){
                db++;
            }
        }
        return db;
    }
    
    public int atlagEletkor(){
        int s = 0;
        for (int i = 0; i < this.emberekLista.size(); i++) {
            s += this.emberekLista.get(i).eletKor();
        }
        
        return s / this.emberekLista.size();
    }
    
    public String legfiatalabbNevu(){
        String legfiatalabb="";
        int kor=this.emberekLista.get(0).eletKor();
        for (int i = 0; i < this.emberekLista.size(); i++) {
            if (this.emberekLista.get(i).eletKor()<=kor) {
                kor=this.emberekLista.get(i).eletKor();
                legfiatalabb=this.emberekLista.get(i).teljesNev();
            }
        }
        return legfiatalabb;
    }
    
    public int legidosebbSorszama(){
        int kor=this.emberekLista.get(0).eletKor();
        int ID=0;
        for (int i = 0; i < this.emberekLista.size(); i++) {
            if (kor<=this.emberekLista.get(i).eletKor()) {
                kor=this.emberekLista.get(i).eletKor();
                ID=i;
            }
        }
        
        return ID;
    }
    
    @Override
    public String toString(){
        String s = "";
        for (Ember e : this.emberekLista) {
            s += e + "\n";
        }
        return s;
    }
    
}
