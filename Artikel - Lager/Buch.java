public class Buch extends Artikel {
    //initialisierung der Attribute
    private String titel;
    private String autor;
    private String verlag;
    
    /**
     * Konstruktor zum initialisiern eines Buches
     *
     * @param artikelNr ist die Artikelnummer als vierstellige Ganzzahl
     * @param bestand ist der Bestand als Ganzzahl
     * @param preis ist der Preis des Atikels
     * @param verlag ist der Verlag, der das Buch herausgebracht hat
     * @param titel ist der Titel des Buches
     * @param autor ist der Autor, der das Buch geschrieben hat
     */
    public Buch(int artikelNr, int bestand, double preis, String verlag, String titel, String autor){
        super(artikelNr,"Medien",bestand,preis);
        if (titel == null)
            throw new IllegalArgumentException("Der Titel darf nicht leer sein");
        if (autor == null)
            throw new IllegalArgumentException("Der Autor darf nicht null sein");
        if (verlag == null)
            throw new IllegalArgumentException("Der verlag darf nicht null sein");
        this.verlag = verlag;
        this.titel = titel;
        this.autor = autor;
    }
    
    /**
     * Methode zum Vergleichen von einem Artikel mit einem anderen
     *
     * @param Buch ist das Objekt, dass verglichen werden soll
     */
    @Override
    public boolean equals(Object Buch){
        if (this == Buch)
            return true;
        if (Buch == null)
            return false;
        if (getClass() != Buch.getClass())
            return false;
        Buch other = (Buch) Buch;
        if (titel == null ){
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel))
            return false;
        if (autor == null ){
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        return true;
    }

    /**
     * get Methode zum weitergeben der Beschreibung eines Buches an die toString Methode
     */
    @Override
    public String getBeschreibung(){
        return "Autor: " + autor + " Titel: " + titel + " Verlag: " + verlag;
    }

    /**
     * Methode zum ausgeben der Attribute eines Buches als Zeichenkette
     */
    @Override
    public String toString(){
        String ausgabe = String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
        return ausgabe;
    }
}