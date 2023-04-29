import java.util.Random;

/**
 * NumberCruncherTopLevel
 * 
 * @jonas_neu_&_marc_perwak
 * @25.04.2023
 */
public class NumberCruncherTopLevel {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private float[] numbers;
    
    private final static String INVALID_OPERATION = "Invalid operation";

    /**
     * Konstruktor für Objekte der Klasse NumberCruncherAnonym
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
     * Tragen Sie hier eine Beschreibung des Interface CrunchOperation ein.
     * 
     * @author (Ihr Name) 
     * @version (eine Versionsnummer oder ein Datum)
     */
    
    public interface CrunchOperation
    {
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
     * Beschreiben Sie hier die Klasse DivideOperation.
     * 
     * @author (Ihr Name) 
     * @version (eine Versionsnummer oder ein Datum)
     */
    public class DivideOperation implements CrunchOperation {
        @Override
        public void crunch(float[] numbers) {
            //float[] numbersSorted = bubbleSort(numbers);
            /*for (int i = 0; i <=  numbers.length/2; i++) {
                numbers[numbers.length-1-i] = numbers[numbers.length-1-i] / numbers[i];
            }*/
            
             // setze max auf das erste Element im Array
            
            float preMin = numbers[numbers.length-1]; // setze min auf das erste Element im Array
            float preMax = numbers[numbers.length-1]; // setze max auf das erste Element im Array
            
            for (int a = 0; a <= numbers.length/2; a++) {
                float min = numbers[0]; // setze min auf das erste Element im Array
                float max = numbers[0];
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] < min && numbers[i] > preMin) {
                        min = numbers[i];
                    }
                    if (numbers[i] > max && numbers[i] < preMax) {
                        max = numbers[i];
                    }
                }
                preMin = min;
                preMax = max;
                System.out.println("MIN: " + min);
                System.out.println("max: " + max);
            }
        }
        
        public void bubbleSort(float[] arr) {  
            int n = arr.length;  
            float temp = 0;  
            for(int i=0; i < n; i++) {
                for(int j=1; j < (n-i); j++) {  
                    if(arr[j-1] > arr[j]) { 
                        //swap elements  
                        temp = arr[j-1];  
                        arr[j-1] = arr[j];  
                        arr[j] = temp;
                    }
                }  
            }
        }
    }

    /**
     * Beschreiben Sie hier die Klasse SubtractOperation.
     * 
     * @author (Ihr Name) 
     * @version (eine Versionsnummer oder ein Datum)
     */
    public class SubtractOperation implements CrunchOperation {
        @Override
        public void crunch(float[] numbers) {
            for (int i = 1; i < numbers.length; i++) {
                numbers[i] = numbers[i] + numbers[i-1];
            }
        }
    }
    
    /**
     * Beschreiben Sie hier die Klasse AverageOperation.
     * 
     * @author (Ihr Name) 
     * @version (eine Versionsnummer oder ein Datum)
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
