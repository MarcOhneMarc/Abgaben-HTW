import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayFunctionsTest {
    ArrayFunctions arrayfunctions;
    
    @Test
    public void berechneMittelwert_mittelwertSollteKorrektSein() {
        final double erwarteterMittelwert = 5;
        double[] array = {10, 5, 5, 5, 0};
        Mittelwert mittelwert = ArrayFunctions.berechneMittelwert(array);
        
        final double tatsaechlicherMittelwert = mittelwert.getMittelwert();
        assertEquals(erwarteterMittelwert, tatsaechlicherMittelwert);
    }
        
    @Test
    public void berechneMittelwert_minSollteKorrektSein() {
        final double erwarteterMinMittelwert = 2.8;
        double[] array = {0, 2.8, 3, 3.3, 4};
        Mittelwert mittelwert = ArrayFunctions.berechneMittelwert(array);
        
        final double tatsaechlicherMinMittelwert = mittelwert.getMin();
        assertEquals(erwarteterMinMittelwert, tatsaechlicherMinMittelwert);
    }

    @Test
    public void berechneMittelwert_maxSollteKorrektSein() {
        final double erwarteterMaxMittelwert = 0;
        double[] array = {0, 2.8, 3, 3.3, 4};
        Mittelwert mittelwert = ArrayFunctions.berechneMittelwert(array);
        
        final double tatsaechlicherMaxMittelwert = mittelwert.getMax();
        assertEquals(erwarteterMaxMittelwert, tatsaechlicherMaxMittelwert);
    }
    
    @Test
    public void berechneMittelwert_arrayNull_erwartetException() {
        double[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArrayFunctions.berechneMittelwert(array);
        });
    }
    
    @Test
    public void stringsAuswerten_SollteKorrektSein() {
        final int erwarteteAnzahlStrings = 3;
        String[] array = {"HTW", "Saar", "klein", "GROESS"};
        int tatsaechlicheAnzahlStrings = ArrayFunctions.stringsAuswerten(array);
        
        assertEquals(erwarteteAnzahlStrings, tatsaechlicheAnzahlStrings);
    }

    @Test
    public void stringsAuswerten_arrayNull_erwartetException() {
        String[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArrayFunctions.stringsAuswerten(array);
        });
    }
}