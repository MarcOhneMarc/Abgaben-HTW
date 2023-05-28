import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.function.Consumer;
import java.util.function.BiPredicate;

/**
* <p>Diese Klasse ist eine Fassade, hinter der Sie Ihre Loesung verstecken. Der Test ruft nur die hier definierten
* Schnittstellenmethoden auf. Loeschen Sie bitte keine Methoden. Wenn Sie eine Methode nicht implementieren
* moechten, lassen Sie bitte die leere Implementierung stehen. Innerhalb der Methoden und in allen anderen Klassen,
* die Sie noch benoetigen, haben Sie alle Freiheiten.</p>
* 
* <p>Wenn Sie Ihre Loesung mit JUnit testen moechten, testen Sie diese Schnittstellenmethoden.</p>
* @author christopher
*
*/
public class Ueb18Fassade {
    
    /**
     * Loest die Aufgabe (c) i.
     * <br />
     * Sortierung nach den folgenden Kriterien:
     * <ol>
     *     <li>Unterkategorie (alphabetisch)</li>
     *     <li>Bestand</li>
     *     <li>Preis</li>
     * </ol>
     * @param lager Das Lager mit der unsortierten Artikelliste.  
     * @return Die sortierte Artikelliste.
     */
    public Artikel[] aufgabe_c_i() {
        Lager lager = new Lager(10);
        
        Artikel artikel11 = new Artikel(3333, "c", 3, 1112);
        Artikel artikel22 = new Artikel(1111, "b", 6, 323);
        Artikel artikel33 = new Artikel(8888, "a", 23, 222);
        Artikel artikel44 = new Artikel(2222, "d", 21, 333);
        
        CD cd11 = new CD(9999, 10, 15, "bInterpret", "bTitel", 154);
        CD cd22 = new CD(3232, 10, 15, "cInterpret", "cTitel", 153);
        CD cd33 = new CD(7777, 10, 15, "aInterpret", "aTitel", 156);
        CD cd44 = new CD(6666, 10, 15, "dInterpret", "dTitel", 159);
        
        lager.legeAnArtikel(artikel11);
        lager.legeAnArtikel(cd11);
        lager.legeAnArtikel(cd22);
        lager.legeAnArtikel(artikel22);
        lager.legeAnArtikel(artikel33);
        lager.legeAnArtikel(cd33);
        lager.legeAnArtikel(cd44);
        lager.legeAnArtikel(artikel44);
        
        //Bestand aufsteigend
        BiPredicate<Artikel, Artikel> kriterium = (artikel1, artikel2) -> {
            // Sortieren nach Unterklassen alphabetisch
            String klasse1 = artikel1.getClass().getSimpleName();
            String klasse2 = artikel2.getClass().getSimpleName();
            return klasse1.compareTo(klasse2) < 0;
        };
        
        System.out.println("A: ");
        Artikel[] sortByUnterkategorie = lager.getSorted(kriterium);
        for (Artikel artikel: sortByUnterkategorie) {
            System.out.println("1: " + artikel.toString());
        }
        
        //Bestand aufsteigend
        BiPredicate<Artikel, Artikel> kriterium2 = (artikel1, artikel2) -> {
            if (artikel1.getArtikelNr() < artikel2.getArtikelNr()) {
                return true;
            } else {
                return false;
            }
        };
        
        System.out.println("B: ");
        Artikel[] sortByBestand = lager.getSorted(kriterium2);
        for (Artikel artikel: sortByBestand) {
            System.out.println("1: " + artikel.toString());
        }
        
        //Bestand aufsteigend
        BiPredicate<Artikel, Artikel> kriterium3 = (artikel1, artikel2) -> {
            // Sortieren nach Unterkategorie
            String klasse1 = artikel1.getClass().getSimpleName();
            String klasse2 = artikel2.getClass().getSimpleName();
            int klasseResult = klasse1.compareTo(klasse2);
            if (klasseResult != 0) {
                return klasseResult < 0;
            }
            
            // Sortieren nach Bestand
            int bestand1 = artikel1.getBestand();
            int bestand2 = artikel2.getBestand();
            if (bestand1 != bestand2) {
                return bestand1 < bestand2;
            }
            
            // Sortieren nach Preis
            double preis1 = artikel1.getPreis();
            double preis2 = artikel2.getPreis();
            return preis1 < preis2;
        };
        
        System.out.println("B: ");
        Artikel[] sortByPreisExtendet = lager.getSorted(kriterium3);
        for (Artikel artikel: sortByPreisExtendet) {
            System.out.println("1: " + artikel.toString());
        }
        return null;
    }
    
    /**
     * Loest die Aufgabe (c) ii.
     * <br />
     * Der Preis aller Artikel wird um 10% reduziert.
     * @param lager Das Lager mit den Artikeln, deren Preise geaendert werden sollen.
     */
    public void aufgabe_c_ii(Lager lager) {
        
    }
    
}