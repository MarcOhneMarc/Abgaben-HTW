import java.io.*;
import java.util.Arrays;

public class LOCAuswertung {
    private static final String NO_FILES_GIVEN = "No files given!";
    private static final String JAVA_FILES_REQ = ".java files are required!";
    
    public static void main(String[] args) throws IOException {
        evaluationOfFiles(args);
    }
    
    /**
     * Methode zum errechnen der Zeilen von den Dateien, deren Dateiname uebergeben wird.
     * 
     * @param files Dateinamen als Liste
     * @throws NoFileGivenException Ausnahme, wenn keine Dateinamen uebergeben werden
     */
    public static void evaluationOfFiles(String[] files) throws IOException {
        if(files.length <1) {
            throw new NoFileGivenException(NO_FILES_GIVEN);
        }
        int sumCount = 0;
        int fileCount = 0;
        for(String file: files) {
            if (!file.endsWith(".java")) {
                System.out.println(JAVA_FILES_REQ);
                continue;
            }
            int linesOfCode = getLines(file);
            sumCount += linesOfCode;
            fileCount++;
            System.out.println(file.toString() +": "+ linesOfCode);
        }
        System.out.println("Gesammt: " + fileCount + " Dateien mit " + sumCount + " Zeilen Code");
    }
    
    /**
     * Hilfsmethode zum errechnen der Zeilen
     * 
     * @param arg Dateinamen als String
     */
    private static int getLines(String arg) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(arg));
        int count = 0;
        boolean isEOF = false;
        do {
            String t = file.readLine();
            if(t!=null) {
                isEOF=true;
                t=t.replaceAll("\\n|\\t|\\s", "");
                if((!t.equals("")) && (!t.startsWith("//"))) {
                    count = count + 1;
                }
            }
            else {
                isEOF=false;
            }
        } while(isEOF);
        file.close();
        return count;
    }
}