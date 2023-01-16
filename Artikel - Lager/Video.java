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
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Video other = (Video) obj;
        if (titel == null ){
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel))
            return false;
        return true;
    }

    @Override
    public String getBeschreibung(){
        return "Titel:" + titel + " Spieldauer:" + spieldauer + " Erschinungsjahr:" + jahr;
    }

    @Override
    public String toString(){
        String ausgabe = String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
        return ausgabe;
    }
}
