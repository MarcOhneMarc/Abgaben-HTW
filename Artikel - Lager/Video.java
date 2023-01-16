public class Video extends Artikel{
    private int spieldauer;
    private int jahr;
    private String titel;


    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr){

        super(artikelNr,"Medien",bestand,preis);
        this.spieldauer = spieldauer;
        this.titel = titel;
        this.jahr = jahr;

    }

    @Override
    public String getBeschreibung(){
        return "Video";
    }

    @Override
    public String toString(){
        String beschreibung = String.format("%s", titel);
        String ausgabe = String.format("%-10d %-40s %-4.2f %-5d", artikelNr, beschreibung, preis, bestand);
        return ausgabe;
    }
}
