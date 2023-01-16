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
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Buch other = (Buch) obj;
        if (titel == null ){
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel))
            return false;
        if (author == null ){
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        return true;
    }

    @Override
    public String getBeschreibung(){
        return "Author:" + author + ", Titel:" + titel + ", Verlag:" + verlag;
    }

    @Override
    public String toString(){
        String ausgabe = String.format("%-10d %-60s %8.2f %10d", artikelNr, getBeschreibung(), preis, bestand);
        return ausgabe;
    }

}
