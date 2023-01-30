import java.io.*;
import java.util.Arrays;

public class LOCAuswertung {
    public static void main(String[] args) throws IOException {
        if(args.length <1) {
            System.out.println("wrong number of arguments");
            System.exit(1);
        }
        int sumCount = 0;
        int fileCount = 0;
        for(String arg: args) {
            if (!arg.endsWith("java")) {
                System.out.println("Die Übergebenen Dataien müssen Java dateinen sein");
                continue;
            }
            int linesOfCode = getLines(arg);
            sumCount += linesOfCode;
            fileCount += 1;
            System.out.println(arg.toString() +": "+ linesOfCode);
        }
        System.out.println("Gesamte: " + fileCount + " Dateien mit " + sumCount + " Lines of Code");
    }
    private static int getLines(String arg) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(arg));
        int count = 0;
        boolean isEOF = false;
        do{
            String t= file.readLine();
            if(t!=null){
                isEOF=true;
                t=t.replaceAll("\\n|\\t|\\s", "");
                if((!t.equals("")) && (!t.startsWith("//"))) {
                    count = count + 1;
                }
            }
            else {
                isEOF=false;
            }
        }while(isEOF);
        file.close();
        return count;
    }
}
