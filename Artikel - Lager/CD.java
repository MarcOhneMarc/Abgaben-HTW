public class CD extends Artikel{

    private String interpret;

    private String titel;

    private int anzahlTitel;

    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel){

        super(artikelNr,"Medien",bestand,preis);
        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;

    }

    @Override
    public String getBeschreibung(){
        return "CD";
    }
    
    @Override
    public String toString(){
        String beschreibung = String.format("%s, %s", interpret, titel);
        String ausgabe = String.format("%-10d %-40s %-4.2f %-5d", artikelNr, beschreibung, preis, bestand);
        return ausgabe;
    }
}
