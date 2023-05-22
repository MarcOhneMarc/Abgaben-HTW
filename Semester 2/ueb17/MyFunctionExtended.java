import java.util.function.Predicate;
@FunctionalInterface
public interface MyFunctionExtended extends MyFunction {
    default MyFunctionExtended conditionateInput(Predicate<Integer> predicate) {
        MyFunctionExtended self = this;
        return value -> {
            if (predicate.test(value)) {
                return self.apply(value);
            } else {
                return 0;
            }
        };
    }

    default MyFunctionExtended conditionateOutput(Predicate<Integer> predicate) {
        MyFunctionExtended self = this;
        return value -> {
            int result = self.apply(value);
            if (predicate.test(result)) {
                return result;
            } else {
                return 0;
            }
        };
    }
}