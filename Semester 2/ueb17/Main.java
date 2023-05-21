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
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {
                return i*i;
            }
        });
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {
                return;
            }
        });
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {

            }
        });
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int i) {

            }
        });
    }
}
