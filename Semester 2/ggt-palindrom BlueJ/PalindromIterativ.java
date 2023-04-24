/**
 * Klasse zur Implementirung des Algoritmus, der auf die Eigenschaft "Palindrom" prueft (iterativ)
 * @author Jonas Neu und Marc Perwak
 */
public class PalindromIterativ implements Palindrom{
    /**
     * Methode zur ueberpruefung ob ein String ein Palindrom ist (iterativ)
     * @param wort Der string, der geprueft werden soll
     * @return Rueckgabe ob der String ein Palindrom ist oder nicht (true: Wert ist Palindrom, false: Wert ist kein Palindrom)
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
