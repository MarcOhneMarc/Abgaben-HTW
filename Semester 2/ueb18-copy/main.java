
/**
 * Beschreiben Sie hier die Klasse main.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class main
{
    public static void main(String[] args){
        
        String str2 = "!bc!d+a!b+ac!d";
        str2 = str2.replaceAll("a", "B0");
        str2 = str2.replaceAll("b", "B1");
        str2 = str2.replaceAll("c", "A0");
        str2 = str2.replaceAll("d", "A1");
        System.out.println(str2);
        
        
        String str = "!a!cd+!ab+b!cd";
        str = str.replaceAll("a", "B0");
        str = str.replaceAll("b", "B1");
        str = str.replaceAll("c", "A0");
        str = str.replaceAll("d", "A1");
        System.out.println(str);
    }
}
