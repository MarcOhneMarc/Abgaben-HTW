import java.util.function.Predicate;
@FunctionalInterface
public interface MyfunctionExtendet extends MyFunction{
    default MyFunction conditionateInput(Predicate<Integer> predicate) {
        return (value) -> {
            if (predicate.test(value)) {
                return this.apply(value);
            } else {
                return 0;
            }
        };
    }

    default int conditionateOutput(Predicate<Integer> predicate) {
        int result = this.apply(0);
        if (predicate.test(result)) {
            return result;
        } else {
            return 0;
        }
    }
}
