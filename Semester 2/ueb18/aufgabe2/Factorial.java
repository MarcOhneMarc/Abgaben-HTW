public class Factorial implements MyFunction{
    @Override
    public int apply(int i) {
        return Main.FunctionEnum.factorial(i);
    }
}
