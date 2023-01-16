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
        return "Interpert:" + interpret+ ", Titel:"+titel;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CD other = (CD) obj;
        if (titel == null ){
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel))
            return false;
        if (interpret == null ){
            if (other.interpret != null)
                return false;
        } else if (!interpret.equals(other.interpret))
            return false;
        return true;
    }
    
    @Override
    public String toString(){
        String ausgabe = String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
        return ausgabe;
    }
}
