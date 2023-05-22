import java.util.function.Predicate;

/**
 * Eine erweiterte Funktionsschnittstelle, die die Funktionalität der MyFunction-Schnittstelle erweitert.
 */
@FunctionalInterface
interface MyFunctionExtended extends MyFunction {
    /**
     * Wendet ein Praedikat auf den Eingabeparameter dieser Funktion an und gibt Ergebnis zurück,
     * wenn Prädikat erfüllt, sonst 0 zurueck.
     *
     * @param predicate das Praedikat, das auf den Eingabeparameter angewendet werden soll
     * @return eine neue Funktion, die das Prädikat auf den Eingabeparameter anwendet und das 
     *          Ergebnis zurückgibt, wenn Prädikat erfüllt, sonst 0 zurueck
     */
    default public MyFunctionExtended conditionateInput(Predicate<Integer> predicate) {

        return x -> predicate.test(x)?this.apply(x) :0;
    }

    /**
     * Wendet ein Praedikat auf das Ergebnis dieser Funktion an und gibt das Ergebnis zurueck,
     * wenn Praedikat erfuellt, sonst 0 zurueck.
     *
     * @param predicate das Prädikat, das auf das Ergebnis angewendet werden soll
     * @return eine neue Funktion, die das Praedikat auf das Ergebnis anwendet und das Ergebnis zurückgibt,
     *         falls das Prädikat erfuellt ist, andernfalls wird 0 zurückgegeben
     */
    default public MyFunctionExtended conditionateOutput (Predicate<Integer> predicate) {
        return x -> {
            int ergebnis = this.apply(x);
            return predicate.test(ergebnis) ? ergebnis : 0;
        };
    }
}