//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Dialog {
    private Scanner input;
    private Getraenkeautomat getraenkeautomat;
    
    private static final int create_automat = 1;
    private static final int delete_automat = 2;
    private static final int fill_automat = 3;
    private static final int del_items_automat = 4;
    private static final int drink_bottle = 5;
    private static final int print_automat = 6;
    private static final int ende = 0;
    
    private static final String ARRAY_MIN_SIZE = "Das Array muss mindestens 2 Werte erhalten!";
    private static final String KEIN_CRUNCHER_INITIALISIERT = "Es wurde noch kein Cruncher Initialisiert!";
    private static final String INDEX_OUT_OF_BOUNCE = "Falscher Index!";

    public Dialog() {
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
        System.out.println("\n[1] Automat erstellen" +
                "\n[2] Automat entfernen" +
                "\n[3] Automat mit Flaschen befüllen" +
                "\n[4] Flaschen aus Automat entfernen" +
                "\n[5] Flasche Trinken" +
                "\n[6] Automat Ausgeben" +
                "\n[0] Zum beenden des Programms");
    }

    private int einlesenFuktion() {
        int funktion = this.input.nextInt();
        this.input.nextLine();
        return funktion;
    }

    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case 0:
                System.out.println("Programmende!");
                break;
            case 1:
                this.createAutomat();
                break;
            case 2:
                this.deleteAutomat();
                break;
            case 3:
                this.fillAutomat();
                break;
            case 4:
                this.delItemsAutomat();
                break;
            case 5:
                this.drinkBottle();
                break;
            case 6:
                this.printAutomat();
                break;
        }

    }


    private void createAutomat() {
        Getraenkeautomat<Flasche> getraenkeautomat = new Getraenkeautomat(10);
        System.out.println(getraenkeautomat);
    }
    
    private void deleteAutomat() {

    }
    
    private void fillAutomat() {

    }
    
    private void delItemsAutomat() {

    }
    
    private void drinkBottle() {

    }
    
    private void printAutomat() {

    }



    public static void main(String[] args) {
        (new Dialog()).start();
    }
}
