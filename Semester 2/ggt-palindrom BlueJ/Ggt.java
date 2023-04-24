/**
 * Klasse zur Berechnung des GGT mit dem Rekursiven Euklid Algoritmus
 * @author Jonas Neu und Marc Perwak
 */
public class Ggt {

    /**
     * Eine Rekursive Methode die das ggt von 2 natürlichen Zahlen berechnet
     * @return Eine Natuerliche Zahl die das GGT der beiden uebergebenen Zahlen darstellt
     */
    public static double ggt(int x, int y) {
        //Wenn x null ist dann ist Y der größte gemeinsame teiler
        //Es wird verglichen welcher der werte größer ist danach dann wird der größere von dem kleineren abgezogen und-
        //- er ruft sich selber wieder auf
        //Solange bis einer der werte 0 ist
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