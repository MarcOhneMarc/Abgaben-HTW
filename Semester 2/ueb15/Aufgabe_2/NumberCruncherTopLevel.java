import java.util.Random;

/**
 * NumberCruncherTopLevel besitzt ein float-Array, welches über den Konstruktor 
 * uebergeben wird.Auf das Float array werden mit der Methode crunch verschiedene
 * Operationen angewandt.
 * 
 * @jonas_neu_&_marc_perwak
 * @25.04.2023
 */
public class NumberCruncherTopLevel {
    // Instanzvariablen
    private float[] numbers;
    
    private final static String INVALID_OPERATION = "Invalid operation";

    /**
     * Konstruktor für Objekte der Klasse NumberCruncherAnonym
     * 
     * @param numbers Das Array mit den Float werten
     */
    public NumberCruncherTopLevel(float[] numbers){
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
        for (String operation: operations) {
            System.out.println("2"+operation);
        }
        for (String op : operations) {
            CrunchOperation operation;
            switch(op) {
                case "sum": 
                    operation = new SumOperation();
                    break;
                case "swirl":
                    operation = new SwirlOperation();
                    break;
                case "divide":
                    operation = new DivideOperation();
                    break;
                case "subtract":
                    operation = new SubtractOperation();
                    break;
                case "average":
                    operation = new AverageOperation();
                    break;
                default:
                    throw new IllegalArgumentException(INVALID_OPERATION);
            }
            if (operation != null) {
                operation.crunch(numbers);
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
     * Das Interface CrunchOperation wird von den verschiedenen
     * Crunch Operationen imlementiert um diese in der Methode Crunch einfacher
     * aufzurufen
     */
    public interface CrunchOperation
    {
        /**
         * Interface Methode crunch
         */
        public void crunch(float[] numbers);
    }
    
    /**
     * Summiert die Elemente des Arrays paarweise von links nach rechts 
     * auf und speichert den neuen Wert in dem jeweils rechten Datenfeld.
     */
    public class SumOperation implements CrunchOperation {
        @Override
        public void crunch(float[] numbers) {
            for (int i = 1; i < numbers.length; i++) {
                numbers[i] = numbers[i] + numbers[i-1];
            }
        }
    }
    
    /**
     * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge des
     * float-Arrays gegeben.
     */
    public class SwirlOperation implements CrunchOperation {
        @Override
        public void crunch(float[] numbers) {
            Random rand1 = new Random();
            Random rand2 = new Random();
            for (int i = 1; i < numbers.length; i++) {
                int randInt1 = rand1.nextInt(numbers.length);
                int randInt2 = rand2.nextInt(numbers.length);
                numbers[randInt1] = numbers[randInt2];
            }
        }
    }

    /**
     * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den
     * neuen Wert im Datenfeld des jeweils größeren Wertes. D.h. der größte Wert wird 
     * durch den Kleinsten geteilt. Der Zweitgrößte durch den Zweitkleinsten usw.
     */
    public class DivideOperation implements CrunchOperation {
        @Override
        public void crunch(float[] numbers) {
            int n = numbers.length;
            //erstellen eines Integer Arrays, welches sich die
            //Positionen nach dem Sortieren mehrkt
            float[] numberPositions = new float[n];
            for(int i = 0; i < n; i++) {
                numberPositions[i] = i;
            }
            //Sortieren des Float Arrays
            float[][] merge = bubbleSort(numbers, numberPositions);
            numbers = merge[0];
            numberPositions = merge[1];
            //Dividiervorgang
            for (int i = 0; i <  n/2; i++) {
            numbers[n-1-i] = numbers[n-1-i] / numbers[i];
            }
            //Ruecksortieren des Float Arrays
            //(Werte an uhrspruengliche Position)
            merge = bubbleSort(numberPositions, numbers);
            numbers = merge[1];
        }

        /**
         * Hilfsmethode zum Sortieren und ruecksortieren der Arrays unter
         * Verwendung von Bubble Sort
         * 
         * @param toSort das zu sortierende Array
         * @param sorted das bereits sortierte array, welches umgekehrt sortiert wird
         */
        public float[][] bubbleSort(float[] toSort, float[] sorted) {
            int n = toSort.length;
            float[][] merge = new float[2][n*2];
            float temp1 = 0;
            float temp2 = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 1; j < (n-i); j++) {
                    if(toSort[j-1] > toSort[j]) {
                        //swap elements
                        temp1 = toSort[j-1];  
                        temp2 = sorted[j-1]; 
                        
                        toSort[j-1] = toSort[j];  
                        sorted[j-1] = sorted[j];  
                        
                        toSort[j] = temp1;
                        sorted[j] = temp2;
                    }
                }
            }
            merge[0] = toSort;
            merge[1] = sorted;
            return merge;
        }
    }

    /**
     * Subtrahiert die Elemente des Arrays paarweise von links nach rechts und 
     * speichert den neuen Wert in dem jeweils rechten Datenfeld. 
     * D.h.: a[1] = a[0] - a[1]; a[2] = a[1] - a[2] usw.
     */
    public class SubtractOperation implements CrunchOperation {
        @Override
        public void crunch(float[] numbers) {
            for (int i = 1; i < numbers.length; i++) {
                numbers[i] = numbers[i] - numbers[i-1];
            }
        }
    }
    
    /**
     * Bestimmt den Durchschnitt aller Werte im Array und speichert 
     * den Durchschnittswert im Datenfeld mit dem größten Wert.
     */
    public class AverageOperation implements CrunchOperation {
        @Override
        public void crunch(float[] numbers) {
            float max = numbers[0];
            int indexVonMax = 0;
            float summeAllerWerte = 0;
            for (int i = 0; i < numbers.length; i++) {
                summeAllerWerte += numbers[i];
                if (numbers[i] > max) {
                    max = numbers[i];
                    indexVonMax = i;
                }
            }
            numbers[indexVonMax] = summeAllerWerte/numbers.length;
        }
    }
}
