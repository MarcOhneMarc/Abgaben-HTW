import java.io.*;
import java.io.PrintWriter;
import java.io.StringWriter;

public class laufzeitMessung {
    public Palindrom palindrom;

    private void messung(String fileName) throws IOException {
        Palindrom palindromRe = new PalindromRekursiv();
        Palindrom palindromIt = new PalindromIterativ();


        BufferedReader var1 = new BufferedReader(new FileReader(fileName));
        //PrintWriter writer = new PrintWriter("messung.csv");

        writer.println("The first line");
        writer.println("The second line");
        int var2 = 0;
        long sysTimeCur;
        long sysTimeAfter;
        boolean var3 = false;

        do {
            String var4 = var1.readLine();
            if (var4 != null) {
                var3 = true;

                    sysTimeCur = System.nanoTime();
                    System.out.println(palindromRe.istPalindrom(var4) + " " + var4);
                    sysTimeAfter = System.nanoTime();
                    writer.println("\nRE,");

                    sysTimeCur = System.nanoTime();
                    System.out.println(palindromIt.istPalindrom(var4) + ": " + var4);
                    sysTimeAfter = System.nanoTime();
                    writer.println("\nIT,");

            } else {
                var3 = false;
            }
        } while(var3);

        var1.close();
    }

    public static void main(String[] args) throws IOException {
        laufzeitMessung messung1 = new laufzeitMessung();

<<<<<<< HEAD
        messung1.messung("palin2.txt");
=======
        messung1.messung("Semester 2/ggt-palindrom BlueJ/palin.txt");
>>>>>>> df5ed6030df86b69c30dbd65d6e2e4a8afb7b972
    }
}
