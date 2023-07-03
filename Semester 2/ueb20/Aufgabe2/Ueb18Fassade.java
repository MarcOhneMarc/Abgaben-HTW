import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Comparator;
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
    public Artikel[] aufgabe_c_i(Lager lager) {
        //Bestand aufsteigend
        Comparator<Artikel> kriterium = (artikel1, artikel2) -> {
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
        
        System.out.println("C: ");
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
        Consumer<Artikel> operation = artikel -> {
            artikel.setPreis((artikel.getPreis())*0.9);
        };

        System.out.println(lager.toString());
        // Sortieren nach Artikelnummer
        lager.applyToArticles(operation);

        System.out.println(lager.toString());
    }
    
    /**
    * Loest die Aufgabe (c) iii.
    * <br />
    * An alle Artikelbezeichnungen wird das Suffix (Sonderangebot) angehaengt.
    * @param lager Das Lager mit den Artikeln, deren Bezeichnungen geaendert werden sollen.
    */
    public void aufgabe_c_iii(Lager lager) {
        Consumer<Artikel> operation = artikel -> {
            if (artikel.getArt() != null)
                artikel.setArt((artikel.getArt())+ " (Sonderangebot)");
        };

        System.out.println(lager.toString());
        // Sortieren nach Artikelnummer
        lager.applyToArticles(operation);

        System.out.println(lager.toString());
    }
    
    /**
    * Loest die Aufgabe (c) iv.
    * <br />
    * Die beiden Operatoren aus den Aufgabenteilen ii und iii werden konkateniert, d.h. alle Preise werden
    * um 10 % reduziert und alle Bezeichnungen werden um das Suffix (Sonderangebot) erweitert.
    * @param lager Das Lager mit den Artikeln, deren Preise und Bezeichnungen geaendert werden sollen.
    */
    public void aufgabe_c_iv(Lager lager) {
        Consumer<Artikel> operation = artikel -> {
            artikel.setPreis((artikel.getPreis())*0.9);
            if (artikel.getArt() != null)
                artikel.setArt((artikel.getArt())+ " (Sonderangebot)");
        };

        System.out.println(lager.toString());
        // Sortieren nach Artikelnummer
        lager.applyToArticles(operation);

        System.out.println(lager.toString());
    }
    
        /**
     * Loest die Aufgabe (h) i.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_i(Lager lager) {
        lager.applyToSomeArticles(a -> a instanceof CD, artikel -> {
            double neuerPreis = artikel.getPreis() * 1.1;
            artikel.setPreis(neuerPreis);
        });
    }
    
    /**
     * Loest die Aufgabe (h) ii.
     * <br />
     * Der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_ii(Lager lager) {
        lager.applyToArticles(artikel -> {
            if (artikel.getBestand() <= 2) {
                double reduziertPreis = artikel.getPreis() * 0.95;
                artikel.setPreis(reduziertPreis);
            }
        });
    }
    
    /**
     * Loest die Aufgabe (h) iii.
     * <br />
     * Der Preis der Buecher eines bestimmten Autors wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     * @param gesuchterAutor Der Autor, dessen Buecher guenstiger werden sollen.
     */
    public void aufgabe_h_iii(Lager lager, String gesuchterAutor) {
        lager.applyToSomeArticles(artikel -> (artikel instanceof Buch) && ((Buch) artikel).getAuthor().equals(gesuchterAutor), artikel -> {
            if (artikel instanceof Buch) {
                double preis = artikel.getPreis();
                double reduzierterPreis = preis * 0.95;
                artikel.setPreis(reduzierterPreis);
            }
        });
    }
    
    /**
     * Loest die Aufgabe (h) iv.
     * <br />
     * Der Preis aller CDs wird um 10 % erhoeht und der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_iv(Lager lager) {
        lager.applyToArticles(artikel -> {
            if (artikel instanceof CD) {
                CD cd = (CD) artikel;
                double alterPreis = cd.getPreis();
                double neuerPreis = alterPreis * 1.1;
                cd.setPreis(neuerPreis);
            }
            if (artikel.getBestand() <= 2) {
                double alterPreis = artikel.getPreis();
                double neuerPreis = alterPreis * 0.95;
                artikel.setPreis(neuerPreis);
            }
        });
    }
    
    /**
     * Loest die Aufgabe (h) v.
     * <br />
     * @param lager Das Lager mit den Artikeln. 
     * @return Eine Liste mit allen Buechern, sortiert nach den Namen der Autoren. 
     */
    public Artikel[] aufgabe_h_v(Lager lager) {
        Artikel[] sortierteListe = lager.getSorted((a1, a2) -> {
            if (a1 instanceof Buch && a2 instanceof Buch) {
                Buch buch1 = (Buch) a1;
                Buch buch2 = (Buch) a2;
                return buch1.getAuthor().compareTo(buch2.getAuthor()) > 0;
            }
            return false;
        });
        return sortierteListe;
    }
    
    /**
     * Loest die Aufgabe (h) vi.
     * <br />
     * @param lager Das Lager, dessen Artikel gefiltert werden sollen.
     * @param gesuchterAutor Der Autor, nach dem gefiltert werden soll.
     * @param minPreis Der kleinste Preis, den die zu filternden Buecher haben sollen.
     * @param maxPreis Der hoechste Preis, den die zu filternden Buecher haben sollen.
     * @return Alle Buecher vom Autor autor und mit einem Preis, der zwischen minPreis und maxPreis liegt.
     */
    public Artikel[] aufgabe_h_vi(Lager lager, String gesuchterAutor, double minPreis, double maxPreis) {
        Artikel[] gefundeneArtikel = (Artikel[]) Arrays.stream(lager.filterAll(artikel -> {
            if (artikel instanceof Buch) {
                Buch buch = (Buch) artikel;
                return buch.getAuthor().equals(gesuchterAutor) &&
                        buch.getPreis() >= minPreis && buch.getPreis() <= maxPreis;
            }
            return false;
        })).toArray();
        return gefundeneArtikel;
    }
}