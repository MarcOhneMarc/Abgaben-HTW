/**
 * Klasse zur Berechnung des GGT mit dem Euklid Algoritmus (rekursiv)
 * @author Jonas Neu und Marc Perwak
 */
public class Ggt {

    /**
     * Eine rekursive Methode die den ggt von 2 natuerlichen Zahlen berechnet
     * @return Eine natuerliche Zahl die den GGT der beiden uebergebenen Zahlen zurueck gibt
     */
    public static double ggt(int x, int y) {
        // 1) Wenn x = null: y ist der größte gemeinsame teiler
        // 2) Vergleich welcher der Werte größer ist, der groessere -
        //    von dem kleineren abgezogen und er ruft sich selber wieder -
        //    auf bis einer der werte 0 ist
        if (x==0){
            return y;
        } else if (y!=0){
            if(x>y){
                x=x-y;
            } else {
                y=y-x;
            }
        }
        else if(y == 0){
            return x;
        }
        return ggt(x,y);
    }
}