import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LagerTest {
    private static final double EPSILON = 0.00000001;
    private Artikel artikel1;
    private Artikel artikel2;
    
    private Artikel artikel11;
    private Artikel artikel22;
    private Artikel artikel33;
    private Artikel artikel44;
    private Lager lager;

    @BeforeEach
    public void setup() {
        artikel1 = new Artikel(1111, "artikel1", 10, 15);
        artikel2 = new Artikel(2222, "artikel2", 20, 30);
        
        
        
        artikel11 = new Artikel(3333, "c", 10, 15);
        artikel22 = new Artikel(1111, "b", 20, 30);
        artikel33 = new Artikel(8888, "a", 10, 15);
        artikel44 = new Artikel(2222, "d", 20, 30);
    }
    
    @Test
    public void testLagerKonstruktor_mitGroesseErstellen_sollteKorrektSein() {
        final int erwarteteGroesse = 5;
        Lager lager = new Lager(erwarteteGroesse);
        
        final int tatsaechlicheLagerGroesse = lager.getLagerGroesse();
        assertEquals(erwarteteGroesse, tatsaechlicheLagerGroesse);
    }
    
    @Test
    public void testLagerKonstruktor_ohneGroesseErstellen_sollteKorrektSein() {
        final int erwarteteGroesse = 10;
        Lager lager = new Lager();
        
        final int tatsaechlicheLagerGroesse = lager.getLagerGroesse();
        assertEquals(erwarteteGroesse, tatsaechlicheLagerGroesse);
    }
    
    @Test
    public void testLagerKonstruktor_mitGroesse0_erwartetException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lager(0);
        });
    }
    
    @Test
    public void testLagerKonstruktor_mitLeererGroesse_erwartetException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lager(' ');
        });
    }
    
    @Test
    public void testLagerKonstruktor_mitNegativerGroesse_erwartetException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lager(-5);
        });
    }
    
    // Methoden
    @Test
    public void testLegeArtikelAn_anzahlArtikelSollteHoeherSein() {
        Lager lager = new Lager(10);
    
        lager.legeAnArtikel(artikel1);
        assertEquals(1, lager.getArtikelAnzahl());
        
        lager.legeAnArtikel(artikel2);
        assertEquals(2, lager.getArtikelAnzahl());
    }
    
    @Test
    public void testLegeArtikelAn_mitBereitsAngelegtemArtikel_erwartetException() {
        Lager lager = new Lager(10);
        
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lager.legeAnArtikel(artikel1);
        });
    }

    @Test
    public void testLegeArtikelAn_mitLagerBereitsVoll_erwartetException() {
        Lager lager = new Lager(1);
        
        lager.legeAnArtikel(artikel1);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lager.legeAnArtikel(artikel2);
        });
    }
    
    @Test
    public void testEntferneArtikel_anzahlArtikelSollteGeringerSein() {
        Lager lager = new Lager(10);
    
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        
        lager.entferneArtikel(artikel1.getArtikelNr());
        assertEquals(1, lager.getArtikelAnzahl());
    }
    
    @Test
    public void testBucheZugang_artikelbestandSollteHoeherSein() {
        Lager lager = new Lager(10);
    
        lager.legeAnArtikel(artikel1);
        
        lager.bucheZugang(artikel1.getArtikelNr(), 10);
        assertEquals(20, artikel1.getBestand());
    }

    @Test
    public void testaenderePreisEinesArtikels_artikelPreisSollteHoeherSein() {
        Lager lager = new Lager(10);
    
        lager.legeAnArtikel(artikel1);
        
        lager.aenderePreisEinesArtikels(artikel1.getArtikelNr(), 100);
        assertEquals(30, artikel1.getPreis());
    }
    
    @Test
    public void testaenderePreisEinesArtikels_artikelPreisWirdNegativ_erwartetException() {
        Lager lager = new Lager(10);
    
        lager.legeAnArtikel(artikel1);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lager.aenderePreisEinesArtikels(artikel1.getArtikelNr(), -110);
        });
    }

    @Test
    public void testaenderePreisEinesArtikels_artikelPreisSollteGeringerSein() {
        Lager lager = new Lager(10);
    
        lager.legeAnArtikel(artikel2);
        
        lager.aenderePreisEinesArtikels(artikel2.getArtikelNr(), -10);
        assertEquals(27, artikel2.getPreis());
    }
    
    @Test
    public void test() {
        Lager lager = new Lager(10);
        // Fügen Sie Artikel zum Lager hinzu

        lager.legeAnArtikel(artikel11);
        lager.legeAnArtikel(artikel22);
        lager.legeAnArtikel(artikel33);
        lager.legeAnArtikel(artikel44);
        
        BiPredicate<Artikel, Artikel> kriterium1 = (artikel1, artikel2) -> {
            if (artikel1.getArtikelNr() < artikel2.getArtikelNr()) {
                return true;
            } else {
                return false;
            }
        };
        
        BiPredicate<Artikel, Artikel> kriterium2 = (artikel1, artikel2) -> {
            return (artikel2.getBeschreibung()).compareTo(artikel1.getBeschreibung()) < 0;
        };

        
        // Sortieren nach Artikelnummer
        System.out.println("1: ");
        System.out.println("1: ");
        System.out.println("1: ");
        Artikel[] sortedByArtikelnummer = lager.getSorted(kriterium1);
        for (Artikel artikel: sortedByArtikelnummer) {
            System.out.println("1: " + artikel.toString());
        }
        // Sortieren nach Bestand
        System.out.println("2: ");
        System.out.println("2: ");
        System.out.println("2: ");
        Comparator<Artikel> beschreibungComparator = Comparator.comparing(Artikel::getArt);
        Artikel[] sortedByBeschreibung = lager.getSorted(kriterium2);
        for (Artikel artikel: sortedByBeschreibung) {
            System.out.println("2: " + artikel.toString());
        }
    }
}
