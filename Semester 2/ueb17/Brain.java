// Funktion ii als Static Nested Class
public class Brain {
    static class FactorialFunction implements MyFunction {
        public int apply(int i) {
            int result = 1;
            for (int x = 2; x <= i; x++) {
                result *= x;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        applyAndPrint(1, 5, new FactorialFunction()); // Funktion ii als Top-Level-Klasse
        applyAndPrint(1, 5, new MyFunction() { // Funktion ii als anonyme Klasse
            public int apply(int i) {
                int result = 1;
                for (int x = 2; x <= i; x++) {
                    result *= x;
                }
                return result;
            }
        });
        applyAndPrint(1, 5, x -> fibonacci(x)); // Funktion iv als Lambda-Ausdruck
        applyAndPrint(1, 5, new MyFunction() { // Funktion iv als anonyme Klasse
            public int apply(int i) {
                return fibonacci(i);
            }
            private int fibonacci(int n) {
                if (n <= 1)
                    return n;
                else
                    return fibonacci(n - 1) + fibonacci(n - 2);
            }
        });
    }
}