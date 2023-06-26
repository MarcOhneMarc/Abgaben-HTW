
/**
 * Beschreiben Sie hier die Klasse main.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class main
{
    public static void main(String[] args){
        
        String str2 = "¬E ∧ ((¬B ∧ ¬C ∧ D) ∨ (B ∧ ¬D ∧ ((A ∧ ¬C) ∨ (¬A ∧ C))))";
        str2 = //str2.replaceAll("A", "D0");
        str2 = //str2.replaceAll("B", "D1");
        str2 = //str2.replaceAll("C", "D2");
        str2 = //str2.replaceAll("D", "D3");
        str2 = str2.replaceAll("E", "Z");
        System.out.println(str2);
    }
}
