import java.util.Random;

/**
 * NumberCruncherAnonym
 * 
 * @jonas_neu_&_marc_perwak
 * @25.04.2023
 */
public class NumberCruncherAnonym {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private float[] numbers;

    /**
     * Konstruktor für Objekte der Klasse NumberCruncherAnonym
     */
    public NumberCruncherAnonym(float[] numbers) {
        // Instanzvariable initialisieren
        this.numbers = numbers;
    }

    /**
     * Diese Methode gibt an, welche Operationen auf das float-Array
     * angewendet werden müssen.
     * 
     * @param operations Die auszufuehrenden Operationen
     */
    public void crunch(String[] operations) {
        for (int i = 0; i < operations.length; i++) {
            switch(operations[i]) {
                case "sum": 
                    sum();
                    break;
                case "swirl":
                    swirl();
                    break;
                case "divide":
                    divide();
                    break;
                case "subtract":
                    subtract();
                    break;
                case "average":
                    average();
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * Diese Methode gibt das float-Array der Klasse zurück.
     * 
     * @return numbers Das float array numbers
     */
    public float[] getNumbers() {
        return this.numbers;
    }
    
    /**
     * Summiert die Elemente des Arrays paarweise von links nach rechts 
     * auf und speichert den neuen Wert in dem jeweils rechten Datenfeld.
     * 
     * @return numbers Das float array numbers
     */
    public void sum() {
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i] + numbers[i-1];
        }
        this.numbers = numbers;
    }
    
    /**
     * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge des
     * float-Arrays gegeben.
     * 
     * @return numbers Das float array numbers
     */
    public void swirl() {
        Random rand1 = new Random();
        Random rand2 = new Random();
        for (int i = 1; i < numbers.length; i++) {
            int randInt1 = rand1.nextInt(numbers.length);
            int randInt2 = rand2.nextInt(numbers.length);
            numbers[randInt1] = numbers[randInt2];
        }
        this.numbers = numbers;
    }
    
    /**
     * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den
     * neuen Wert im Datenfeld des jeweils größeren Wertes. D.h. der größte Wert wird durch
     * den Kleinsten geteilt.
     * 
     * @return numbers Das float array numbers
     */
    public void divide() {
        //ToDo
        this.numbers = numbers;
    }
    
    /**
     * Subtrahiert die Elemente des Arrays paarweise von links nach rechts 
     * auf und speichert den neuen Wert in dem jeweils rechten Datenfeld.
     * 
     * @return numbers Das float array numbers
     */
    public void subtract() {
        //ToDo
        this.numbers = numbers;
    }
    
    /**
     * Bestimmt den Durchschnitt aller Werte im Array und speichert den Durchschnittswert 
     * im Datenfeld mit dem größten Wert.
     * 
     * @return numbers Das float array numbers
     */
    public void average() {
        //ToDo
        this.numbers = numbers;
    }
}