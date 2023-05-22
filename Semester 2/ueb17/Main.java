import java.util.function.Predicate;

public class Main {

    public enum FunctionEnum {
        I(x -> (int) Math.pow(x, 2)),
        II(x -> (int) factorial(x)),
        III(x -> (int) Math.pow(x, x + 1)),
        IV(x -> (int) fibonacci(x));

        private final MyFunction function;

        FunctionEnum(MyFunction function) {
            this.function = function;
        }

        public MyFunction getFunction() {
            return function;
        }

        public static int factorial(int n) {
            if (n == 0)
                return 1;
            return n * factorial(n - 1);
        }

        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }

    private Main() {
        
    }

    public static void applyAndPrint(int i, int j, MyFunction f) {
        for (int x = i; x <= j; x++) {
            int result = f.apply(x);
            System.out.println(result);
        }
    }

    public static class FactorialNasted implements MyFunctionExtended{
        @Override
        public int apply(int i) {
            return Main.FunctionEnum.factorial(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Berechnung mit Lambdas");
        System.out.println("\nI");
        applyAndPrint(1, 5, FunctionEnum.I.getFunction());
        System.out.println("\nII");
        applyAndPrint(1, 5, FunctionEnum.II.getFunction());
        System.out.println("\nII");
        applyAndPrint(1, 5, FunctionEnum.III.getFunction());
        System.out.println("\nIV");
        applyAndPrint(1, 5, FunctionEnum.IV.getFunction());

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

        System.out.println("\nBerechnung mit TopLvL Klassen");
        System.out.println("II");
        Factorial factorialTopLvl = new Factorial();
        applyAndPrint(1,5, factorialTopLvl);

        System.out.println("\nBerechnung mit Static Nasted Klassen");
        System.out.println("II");
        Main.FactorialNasted factorialNasted = new FactorialNasted();
        applyAndPrint(1,5, factorialNasted);
        System.out.println("Test");
        
        
        Predicate<Integer> odd = new Predicate<Integer>() {
            public boolean test(Integer i) {
                return i % 2 != 0;
            }
        };

        Predicate<Integer> even = i -> i % 2 == 0;

        int number1 = 3;
        int number2 = 4;

        System.out.println(odd.test(number1) ? number1 : null);  // Output: 3
        System.out.println(odd.test(number2) ? number2 : null);  // Output: null

        System.out.println(even.test(number1) ? number1 : null);  // Output: null
        System.out.println(even.test(number2) ? number2 : null);  // Output: 4
        
        System.out.println("/nWAQDASPD");

        MyFunction functionF = x -> {
            if (odd.test(x)) {
                return FunctionEnum.factorial(x);
            } else {
                return 0;
            }
        };

        MyFunction functionF2 = x -> {
            if (even.test(x)) {
                return FunctionEnum.factorial(x);
            } else {
                return 0;
            }
        };

        // ...

        System.out.println("\n FAK ungerade");
        applyAndPrint(1, 10, functionF);

        System.out.println("\n FAK gerade");
        applyAndPrint(1, 10, functionF2);
    }
}