import java.util.function.Predicate;

/**
 * Eine Klasse, die verschiedene mathematische Funktionen 
 * implementiert und anwendet.
 */
public class Main{

    public enum FunctionEnum {
        I(x -> (int) Math.pow(x, 2)), // Funktion I: x^2
        II(x -> (int) factorial(x)), // Funktion II: Fakultät von x
        III(x -> (int) Math.pow(x, x + 1)), // Funktion III: x^(x+1)
        IV(x -> (int) fibonacci(x)); // Funktion IV: Fibonacci-Zahl an Position x

        private final MyFunction function;

        FunctionEnum(MyFunction function) {
            this.function = function;
        }

        public MyFunction getFunction() {
            return function;
        }
        
        /**
         * Berechnet die Fakultät einer gegebenen Zahl.
         *
         * @param n die Zahl, deren Fakultät berechnet werden soll
         * @return die Fakultät der gegebenen Zahl
         */
        public static int factorial(int n) {
            // Basisfall: Fakultät von 0 ist 1
            if (n == 0)
                return 1;
            // Rekursiver Aufruf Fakultät
            return n * factorial(n - 1);
        }

        /**
         * Berechnet die Fibonacci-Zahl an einer gegebenen Position.
         *
         * @param n die Position der Fibonacci-Zahl
         * @return die Fibonacci-Zahl an der gegebenen Position
         */
        public static int fibonacci(int n) {
            // Basisfaelle: Fibonacci-Zahlen für 0 und 1 sind jeweils 0 und 1
            if (n <= 1) {
                return n;
            } else {
                // Rekursiver Aufruf Fibonacci-Zahl an Position n
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }

    private Main() {
        
    }

    /**
     * Wendet eine gegebene Funktion auf einen Bereich von Zahlen 
     * an und gibt die Ergebnisse aus.
     *
     * @param i die Startzahl des Bereichs
     * @param j die Endzahl des Bereichs
     * @param f die Funktion, die angewendet werden soll
     */
    public static void applyAndPrint(int i, int j, MyFunction f) {
        for (int x = i; x <= j; x++) {
            // Anwendung der Funktion auf die aktuelle Zahl x
            int result = f.apply(x);
            // Ausgabe des Ergebnisses
            System.out.println(result);
        }
    }

    /**
     * Eine Klasse, die die Faktorielfunktion als Implementierung 
     * der MyFunctionExtended-Schnittstelle verwendet.
     */
    public static class FactorialNasted implements MyFunctionExtended{

        public int apply(int i) {
            // Aufruf der Faktorielfunktion aus der FunctionEnum-Klasse
            return Main.FunctionEnum.factorial(i);
        }
    }

    /**
     * Die Hauptmethode des Programms.
     */
    public static void main(String[] args) {
        // Ausgabe der Berechnungen mit Lambdas
        System.out.println("Berechnung mit Lambdas");
        System.out.println("\nI");
        applyAndPrint(1, 5, FunctionEnum.I.getFunction());
        System.out.println("\nII");
        applyAndPrint(1, 5, FunctionEnum.II.getFunction());
        System.out.println("\nII");
        applyAndPrint(1, 5, FunctionEnum.III.getFunction());
        System.out.println("\nIV");
        applyAndPrint(1, 5, FunctionEnum.IV.getFunction());

        // Ausgabe der Berechnungen mit anonymen Klassen
        System.out.println("Berechnung mit Anonymen Klassen");
        System.out.println("\nI");
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {
                return i*i;
            }
        });
        System.out.println("\nII");
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {
                return FunctionEnum.factorial(i);
            }
        });
        System.out.println("\nIII");
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {
                return i * i+1;
            }
        });
        System.out.println("\nIV");
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {
                return FunctionEnum.fibonacci(i);
            }
        });

        // Ausgabe der Berechnungen mit Top-Level-Klassen
        System.out.println("\nBerechnung mit TopLvL Klassen");
        System.out.println("II");
        Factorial factorialTopLvl = new Factorial();
        applyAndPrint(1,5, factorialTopLvl);

        // Ausgabe der Berechnungen mit statischen Nested-Klassen
        System.out.println("\nBerechnung mit Static Nasted Klassen");
        System.out.println("II");
        FactorialNasted factorialNasted = new FactorialNasted();
        applyAndPrint(1,5, factorialNasted);
        System.out.println("Test");
        
        // Erstellung von Prädikaten für gerade und ungerade Zahlen
        Predicate<Integer> odd = new Predicate<Integer>() {
            public boolean test(Integer i) {
                return i % 2 != 0;
            }
        };

        Predicate<Integer> even = i -> i % 2 == 0;

        int number1 = 3;
        int number2 = 4;

        // Überprüfung der Zahlen mit den Prädikaten und Ausgabe des Ergebnisses
        System.out.println(odd.test(number1) ? number1 : null);  // Output: 3
        System.out.println(odd.test(number2) ? number2 : null);  // Output: null

        System.out.println(even.test(number1) ? number1 : null);  // Output: null
        System.out.println(even.test(number2) ? number2 : null);  // Output: 4

        // Erstellung einer Funktion und Anwendung eines 
        // Prädikats zur Konditionierung der Eingabe
        MyFunctionExtended functionE = x -> x * x;
        functionE = functionE.conditionateInput(even) ;
        System.out.println("\nQuadratzahlen fuer gerade Zahlen:");
        applyAndPrint(1, 10, functionE);

        // Erstellung von Funktionen und Anwendung eines Prädikats 
        // zur Konditionierung der Ein- und Ausgabe
        MyFunctionExtended functionF = x -> FunctionEnum.factorial(x) ;
        MyFunctionExtended functionF2 = x -> odd.test(FunctionEnum.factorial(x)) ? FunctionEnum.factorial(x) : 0;
        functionF = functionF.conditionateInput(odd);
        functionF2 = functionF2.conditionateOutput(odd);

        System.out.println("\nFakultät von ungeraden Zahlen:");
        applyAndPrint(1, 10, functionF);
        System.out.println("\nUngerade Fakultaeten:");
        applyAndPrint(1, 10, functionF2) ;


        System.out.println("Fakultaet mit TLC und OMR");
        applyAndPrint(1,10, factorialTopLvl::apply);

        System.out.println("Fakultaet mit SNC und SMR");
        applyAndPrint(1,10, new FactorialNasted::apply);
    }
}