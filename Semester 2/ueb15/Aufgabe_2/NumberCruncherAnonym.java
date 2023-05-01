import java.util.Random;

/**
 * NumberCruncherAnonym besitzt ein float-Array, welches über den Konstruktor 
 * uebergeben wird.Auf das Float array werden mit der Methode crunch verschiedene
 * Operationen angewandt.

 * 
 * @jonas_neu_&_marc_perwak
 * @25.04.2023
 */
public class NumberCruncherAnonym {
    // Instanzvariablen
    private float[] numbers;
    
    private final static String INVALID_OPERATION = "Invalid operation";

    /**
     * Konstruktor für Objekte der Klasse NumberCruncherAnonym
     * 
     * @param numbers Das Array mit den Float werten
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
            NumberOperation numberOp = null;
            switch(operations[i]) {
                case "sum":
                    /**
                     * Summiert die Elemente des Arrays paarweise von links nach rechts 
                     * auf und speichert den neuen Wert in dem jeweils rechten Datenfeld.
                     */
                    numberOp = new NumberOperation() {
                        public float[] performOperation(float[] numbers) {
                            for (int i = 1; i < numbers.length; i++) {
                                numbers[i] = numbers[i] + numbers[i-1];
                            }
                            return numbers;
                        }
                    };
                    break;
                case "swirl":
                    /**
                     * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge des
                     * float-Arrays gegeben.
                     */
                    numberOp = new NumberOperation() {
                        public float[] performOperation(float[] numbers) {
                            Random rand1 = new Random();
                            Random rand2 = new Random();
                            for (int i = 1; i < numbers.length; i++) {
                                int randInt1 = rand1.nextInt(numbers.length);
                                int randInt2 = rand2.nextInt(numbers.length);
                                numbers[randInt1] = numbers[randInt2];
                            }
                            return numbers;
                        }
                    };
                    break;
                case "divide":
                    /**
                     * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den
                     * neuen Wert im Datenfeld des jeweils größeren Wertes. D.h. der größte Wert wird 
                     * durch den Kleinsten geteilt. Der Zweitgrößte durch den Zweitkleinsten usw.
                     */
                    numberOp = new NumberOperation() {
                        public float[] performOperation(float[] numbers) {
                            int n = numbers.length;
                            float[] numberPositions = new float[n];
                            for(int i = 0; i < n; i++) {
                                numberPositions[i] = i;
                            }
                            float[][] merge = bubbleSort(numbers, numberPositions);
                            numbers = merge[0];
                            numberPositions = merge[1];
                            for (int i = 0; i <  numbers.length/2; i++) {
                            numbers[numbers.length-1-i] = numbers[numbers.length-1-i] / numbers[i];
                            }
                            merge = bubbleSort(numberPositions, numbers);
                            numbers = merge[1];
                            return numbers;
                        }
                    };
                    break;
                case "subtract":
                    /**
                    * Subtrahiert die Elemente des Arrays paarweise von links nach rechts und 
                    * speichert den neuen Wert in dem jeweils rechten Datenfeld. 
                    * D.h.: a[1] = a[0] - a[1]; a[2] = a[1] - a[2] usw.
                    */
                    numberOp = new NumberOperation() {
                        public float[] performOperation(float[] numbers) {
                            for (int i = 1; i < numbers.length; i++) {
                                numbers[i] = numbers[i] - numbers[i-1];
                            }
                            return numbers;
                        }
                    };
                    break;
                case "average":
                    /**
                    * Bestimmt den Durchschnitt aller Werte im Array und speichert 
                    * den Durchschnittswert im Datenfeld mit dem größten Wert.
                    */
                    numberOp = new NumberOperation() {
                        public float[] performOperation(float[] numbers) {
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
                            return numbers;
                        }
                    };
                    break;
                default:
                    throw new IllegalArgumentException(INVALID_OPERATION);
            }
            if (numberOp != null) {
                this.numbers = numberOp.performOperation(this.numbers);
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
    
    /**
     * Anonyme Schnittstellenklasse
     */
    private interface NumberOperation {
        float[] performOperation(float[] numbers);
    }
}