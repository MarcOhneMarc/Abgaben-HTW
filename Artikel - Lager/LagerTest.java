public class LagerTest {
    private Lager lager;
    
    public static void main(String[] args) {
        Lager lager = new Lager(10);
        
        Artikel artikel1 = new Artikel(1111, "Artikel1", 10, 15);
        Artikel artikel2 = new Artikel(2222, "Artikel2", 20, 30);
        Video vid1 = new Video(1323, 123, 333, "Titel", 90, 2003);
        Buch buch1 = new Buch(3232, 123, 333, "Schlaeger", "Mathe 1", "thommen");
        CD cd1 = new CD(4444, 123, 333, "Interpret", "Titel", 12);
        
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.legeAnArtikel(vid1);
        lager.legeAnArtikel(buch1);
        lager.legeAnArtikel(cd1);
        
        System.out.println(lager.ausgebenBestandsListe());
        System.out.println(lager.toString());
    }
    
}