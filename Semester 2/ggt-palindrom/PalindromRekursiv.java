/**
 * Klasse zur Implementirung eines Algoritmus der Palindrome mit Rekursiven ansatz findet
 * @author Jonas Neu und Marc Perwak
 */
public class PalindromRekursiv implements Palindrom {
    /**
     * Methode zur pruefung ob ein String ein Palindrom ist (Rekursiv)
     * @param wort stelt denn string da der geprueft werden soll
     * @return ein boolscher wert der angibt ob ein wort ein Palindrom ist oder nicht
     */
    public boolean istPalindrom(String wort) {
        //Entfernen aller Sonderzeichen und whitespaces
        wort = (wort.toUpperCase()).replaceAll("[\\s$&+,:;=?@#|´’'<>.^*()%!-]", "");
        if (wort.length() == 1 || wort.length() == 0) // wenn wert 0 oder 1 dann ist es ein Plaindrom
            return true;
        // Erster und letzter buchstabe werdern verglichen wenn gleich dann Selbstaufruf mit substing ohne ersten und letzen
        if (wort.charAt(0) == wort.charAt(wort.length()-1))
            return istPalindrom(wort.substring(1, wort.length()-1));
        return false;
    }
}

