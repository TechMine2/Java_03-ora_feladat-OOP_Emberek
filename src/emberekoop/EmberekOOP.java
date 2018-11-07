package emberekoop;

public class EmberekOOP {

    public static void main(String[] args) {

        Ember akos = new Ember(); //default konstruktort hívja meg!!!
        Ember laszlo = new Ember("Debreczeni László", "1996-01-13", "Budapest");
        Ember niki = new Ember("Gáti Nikolett", "1997-10-12", "Szeged");
        
        System.out.println(akos);
        System.out.println(laszlo);
        System.out.println(niki);
        
        System.out.println(laszlo.szuletesiEv());
        System.out.println(niki.eletKor());
        
        System.out.println(niki.vezetekNev());
        System.out.println(niki.keresztNev());
        System.out.println(laszlo.monogram());
        
        Emberek sokEmber = new Emberek();
        System.out.println(sokEmber);

        Emberek nagyonSokEmber = new Emberek("emberek.txt");
        System.out.println(nagyonSokEmber);
        
        System.out.println("Októberben születettek száma: " 
                + nagyonSokEmber.adottHonapbanSzuletettekSzama(10));
       
        
        System.out.println("Átlag életkor: " + nagyonSokEmber.atlagEletkor());
        System.out.println("Legfiatalabb: " + nagyonSokEmber.legfiatalabbNevu());
        System.out.println("Legidősebb sorszáma: " + nagyonSokEmber.legidosebbSorszama());
    }
    
}
