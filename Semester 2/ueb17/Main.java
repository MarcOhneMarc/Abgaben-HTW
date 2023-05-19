public class Main {
    
    private Main() {
    }
    
    public static void applyAndPrint(int i, int j, MyFunction f) {
        for (int x = i; x <= j; x++) {
            int result = f.apply(x);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
    }
}