import java.util.function.Predicate;
@FunctionalInterface
interface MyFunctionExtended extends MyFunction {
    default public MyFunctionExtended conditionateInput(Predicate<Integer> predicate) {

        return x -> predicate.test(x)?this.apply(x) :0;
    }

    default public MyFunctionExtended conditionateOutput (Predicate<Integer> predicate) {
        return x -> {
            int ergebnis = this.apply(x);
            return predicate.test(ergebnis) ? ergebnis : 0;
        };
    }
}
