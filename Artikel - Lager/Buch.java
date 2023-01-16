public class Buch extends Artikel {

    private String titel;

    private String author;

    private String verlag;

    public Buch(int artikelNr, int bestand, double preis, String verlag, String titel, String author){

        super(artikelNr,"Medien",bestand,preis);
        this.verlag = verlag;
        this.titel = titel;
        this.author = author;
    }

    @Override
    public String getBeschreibung(){
        return "Buch";
    }

    @Override
    public String toString(){
        String beschreibung = String.format("%s, %s, %s", author, titel, verlag);
        String ausgabe = String.format("%-10d %-40s %-4.2f %-5d", artikelNr, beschreibung, preis, bestand);
        return ausgabe;
    }

}
