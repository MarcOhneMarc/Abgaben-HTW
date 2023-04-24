/**
 * Klasse zur Implementirung eines Algoritmus der Palindrome mit Iterativen ansatz findet
 * @author Jonas Neu und Marc Perwak
 */
public class PalindromIterativ implements Palindrom{
    /**
     * Methode zur pruefung ob ein String ein Palindrom ist (Iterativ)
     * @param wort stelt denn string da der geprueft werden soll
     * @return ein boolscher wert der angibt ob ein wort ein Palindrom ist oder nicht
     */
    public boolean istPalindrom(String wort) {
        //Entfernen aller Sonderzeichen und whitespaces
        wort = (wort.toUpperCase()).replaceAll("[\\s$&+,:;=?@#|´’'<>.^*()%!-]", "");
        // Mit jedem scheifen durchlauf wird ein buchstaben weiter gerückt von hinten und vorne und verglichen
        for (int i = 0; i < wort.length(); i++) {
            if (wort.charAt(i) != wort.charAt(wort.length() - 1 - i))
                return false;
        }
        return true;
    }
}
