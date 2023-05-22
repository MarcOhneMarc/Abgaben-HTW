import java.util.function.Predicate;
@FunctionalInterface
interface MyFunctionExtended extends MyFunction {
    default MyFunctionExtended conditionateInput(Predicate<Integer> predicate) {
        return value -> {
            if (predicate.test(value)) {
                return this.apply(value);
            } else {
                return 0;
            }
        };
    }

    default MyFunctionExtended conditionateOutput(Predicate<Integer> predicate) {
        return value -> {
            int result = this.apply(value);
            if (predicate.test(result)) {
                return result;
            } else {
                return 0;
            }
        };
    }
}
