/**
 * Klasse zur Implementirung des Algoritmus, der auf die Eigenschaft "Palindrom" prueft (rekursiv)
 * @author Jonas Neu und Marc Perwak
 */
public class PalindromRekursiv implements Palindrom {
    /**
     * Methode zur ueberpruefung ob ein String ein Palindrom ist (rekursiv)
     * @param wort Der string, der geprueft werden soll
     * @return Rueckgabe ob der String ein Palindrom ist oder nicht (true: Wert ist Palindrom, false: Wert ist kein Palindrom)
     */
    public boolean istPalindrom(String wort) {
        //entfernen aller Sonderzeichen und Whitespaces
        wort = (wort.toUpperCase()).replaceAll("[\\s$&+,:;=?@#|´’'<>.^*()%!-]", "");
        if (wort.length() == 1 || wort.length() == 0) // wenn wert 0 oder 1 dann ist es ein Plaindrom
            return true;
        //Erster und letzter Buchstabe werdern verglichen. Sind diese gleich: 
        //  rekursiver Aufruf des Substrings ohne erstes und letztes Zeichen
        if (wort.charAt(0) == wort.charAt(wort.length()-1))
            return istPalindrom(wort.substring(1, wort.length()-1));
        return false;
    }
}

