public class Fibonacci implements MyFunction{
    @Override
    public int apply(int i) {
        return Main.FunctionEnum.fibonacci(i);
    }
}
