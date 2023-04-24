import java.io.*;

public class laufzeitMessung {
    public Palindrom palindrom;

    private void messung(String fileName) throws IOException {
        Palindrom palindromRe = new PalindromRekursiv();
        Palindrom palindromIt = new PalindromIterativ();


        BufferedReader var1 = new BufferedReader(new FileReader(fileName));
        FileWriter writer = new FileWriter("Semester 2/ggt-palindrom BlueJ/messung.csv", true);
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
                    writer.write("\nRE," + var4.length() + "," + (sysTimeAfter - sysTimeCur));

                    sysTimeCur = System.nanoTime();
                    System.out.println(palindromIt.istPalindrom(var4) + ": " + var4);
                    sysTimeAfter = System.nanoTime();
                    writer.write("\nIT,"  + var4.length() + "," + (sysTimeAfter - sysTimeCur));

            } else {
                var3 = false;
            }
        } while(var3);

        var1.close();
    }

    public static void main(String[] args) throws IOException {
        laufzeitMessung messung1 = new laufzeitMessung();

        messung1.messung("Semester 2/ggt-palindrom BlueJ/palin2.txt");
    }
}
