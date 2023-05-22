import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    public void testApplyAndPrint_Lambda() {
        String expectedOutput = "1\n4\n9\n16\n25\n";
        Assertions.assertEquals(expectedOutput, getPrintedOutput(() -> Main.main(null)));
    }

    @Test
    public void testApplyAndPrint_AnonymousClass() {
        String expectedOutput = "1\n4\n9\n16\n25\n";
        Assertions.assertEquals(expectedOutput, getPrintedOutput(() -> Main.main(null)));
    }

    @Test
    public void testApplyAndPrint_TopLevelClass() {
        String expectedOutput = "1\n2\n6\n24\n120\n";
        Assertions.assertEquals(expectedOutput, getPrintedOutput(() -> Main.main(null)));
    }

    @Test
    public void testApplyAndPrint_StaticNestedClass() {
        String expectedOutput = "1\n2\n6\n24\n120\n";
        Assertions.assertEquals(expectedOutput, getPrintedOutput(() -> Main.main(null)));
    }

    private String getPrintedOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        runnable.run();

        System.out.flush();
        System.setOut(originalPrintStream);
        return outputStream.toString();
    }
}