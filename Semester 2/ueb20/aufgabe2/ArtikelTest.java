import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArtikelTest {

    private Artikel artikel;


    @Test
    public void artikelNrTestRichtig(){
        artikel = new Artikel(9999, "brot", 10, 20);
        int aritkelNrErwarted = 9999;
        assertEquals(aritkelNrErwarted, artikel.getArtikelNr());
    }
    @Test
    public void TestBucheAbgangErwarteterAbgang(){
        Artikel artikel = new Artikel(8773, "brot", 10, 20);
        int bestandDavor = artikel.getBestand();
        int erwarteterErwarteterBestand = bestandDavor - 5;
        artikel.bucheAbgang(5);

        assertEquals(erwarteterErwarteterBestand, artikel.getBestand(), "Der Artikel wurde Korekt abgebucht auf 5");
    }
    @Test
    public void TestBucheZugangErwarteterZugang(){
        Artikel artikel = new Artikel(8773, "brot", 10, 20);
        int bestandDavor = artikel.getBestand();
        int erwarteterErwarteterBestand = bestandDavor +10;
        artikel.bucheZugang(10);

        assertEquals(erwarteterErwarteterBestand, artikel.getBestand(), "Der Artikel wurde Korekt erhöht auf 20");
    }

    @Test
    public void TestArtikelnummerKurzErwarteteException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Artikel(999, "brot", 10, 20);
        });
    }
    @Test
    public void TestArtikelnummerLangErwarteteException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Artikel(10000, "brot", 10, 20);
        });
    }
    @Test
    public void TestArtikelnummerNegativErwarteteException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Artikel(-8773, "brot", 10, 20);
        });
    }

    @Test
    public void TestBestandNegativErwarteteException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Artikel(8773, "brot", -10, 20);
        });
    }
    @Test
    public void TestArtNullErwarteteException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Artikel(8773, "",10, 20);
        });
    }
    @Test
    public void TestBucheAbgangNegativErwarteteException(){
        Artikel artikel = new Artikel(8773, "brot", 10, 20);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            artikel.bucheAbgang(20);
        });
    }
    @Test
    public void TestBucheAbgangErwarteteException(){
        Artikel artikel = new Artikel(8773, "brot", 10, 20);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            artikel.bucheAbgang(-20);
        });
    }

}
