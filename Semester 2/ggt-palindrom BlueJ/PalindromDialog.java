import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PalindromDialog {
    private Scanner input;
    private Palindrom palindrom;
    private static final int pruefeString = 1;
    private static final int puefeDatei = 2;
    private static final int ende = 0;
    private static final String STRING_DARF_NICHT_NULL_SEIN = "Der Uebergebene String darf nicht leer sein";
    private static final String METHODE_NICHT_VERFUEGBAR = "Die von ihnen angegebene Methode Existiert nicht bitte geben sie 1 oder 2 ein";

    public PalindromDialog() {
        this.input = new Scanner(System.in);
    }

    public void start() {
        int funktion = 0;

        do {
            try {
                this.menu();
                funktion = this.einlesenFuktion();
                this.ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException var3) {
                System.out.println(var3);
            } catch (InputMismatchException var4) {
                System.out.println(var4);
                this.input.nextLine();
            } catch (Exception var5) {
                System.out.println(var5);
                var5.printStackTrace(System.out);
            }
        } while(funktion != 0);

    }

    private void menu() {
        System.out.println("\nGib '1' ein um einen Sting einzugeben und Ueberpruefen zu lassen" +
                "\nGib '2' ein um eine Datei einzulesen die dann Zeile um Zeile geprueft wird" +
                "\nGib '0' ein zum beenden des Programms");
    }

    private int einlesenFuktion() {
        int funktion = this.input.nextInt();
        this.input.nextLine();
        return funktion;
    }

    private void ausfuehrenFunktion(int funktion) throws IOException {
        switch (funktion) {
            case 0:
                System.out.println("Programmende!");
                break;
            case 1:
                this.pruefeString();
                break;
            case 2:
                this.puefeDatei();
        }

    }

    private void pruefeString(){
        System.out.println("Geben sie bitte denn zu pruefenden String ein");
        String checkSting = input.nextLine();
        System.out.println("Welche methode wollen sie verwenden \n(1) Rekursiv \n(2) Iterativ");
        int method = input.nextInt();
        input.nextLine();

        if ((checkSting.trim()).isEmpty())
            throw new IllegalArgumentException(STRING_DARF_NICHT_NULL_SEIN);
        if (method < 1 || method > 2)
            throw new IllegalArgumentException(METHODE_NICHT_VERFUEGBAR);

        if (method == 1){
            Palindrom palindromRE = new PalindromRekursiv();
            System.out.println(palindromRE.istPalindrom(checkSting));
        } else if (method == 2){
            Palindrom palindromIT = new PalindromIterativ();
            System.out.println(palindromIT.istPalindrom(checkSting));
        }

    }

    private void puefeDatei() throws IOException {
        System.out.println("Gebe bitte denn Pfad der datei ein");
        String fileName = input.nextLine();
        System.out.println("Welche methode wollen sie verwenden \n(1) Rekursiv \n(2) Iterativ");
        int method = input.nextInt();
        input.nextLine();

        if ((fileName.trim()).isEmpty())
            throw new IllegalArgumentException(STRING_DARF_NICHT_NULL_SEIN);
        if (method < 1 || method > 2)
            throw new IllegalArgumentException(METHODE_NICHT_VERFUEGBAR);

        System.out.println(loadFile("Semester 2/ggt-palindrom/TestFiles/" + fileName, method));

    }

    private String loadFile(String fileName, int method) throws IOException {
        BufferedReader var1 = new BufferedReader(new FileReader(fileName));
        int var2 = 0;
        boolean var3 = false;

        do {
            String var4 = var1.readLine();
            if (var4 != null) {
                var3 = true;
                if (method == 1){
                    Palindrom palindromRE = new PalindromRekursiv();
                    System.out.println(palindromRE.istPalindrom(var4) + " " + var4);
                } else if (method == 2){
                    Palindrom palindromIT = new PalindromIterativ();
                    System.out.println(palindromIT.istPalindrom(var4) + ": " + var4);
                }
            } else {
                var3 = false;
            }
        } while(var3);

        var1.close();
        return "";
    }

    public static void main(String[] args) {
        (new PalindromDialog()).start();
    }
}