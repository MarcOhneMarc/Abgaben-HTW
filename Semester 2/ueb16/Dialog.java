//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Dialog zum anlegen von Getraenkeautomaten. Diese beinhalten Flaschen, welche mit Getreanken gefuellt sind.
 * 
 * @Jonas_Neu_&_Marc_Perwak
 */
public class Dialog {

    private Scanner input;
    private Getraenkeautomat getraenkeautomat;
    private Flasche flasche;
    private int automatType;

    private Flasche letzteFlasche;
    private static final int create_automat = 1;
    private static final int delete_automat = 2;
    private static final int fill_automat = 3;
    private static final int del_items_automat = 4;
    private static final int drink_bottle = 5;
    private static final int print_automat = 6;
    private static final int ende = 0;

    private static final String type_nicht_null = "Der Type darf nicht null sein";
    private static final String type_ungueltig = "Der Type ist Ungueltig";
    private static final String Capacity_ungueltig = "Die Capazitaet muss hoher als 0 sein";
    private static final String INDEX_OUT_OF_BOUNCE = "Falscher Index!";
    private static final String KEIN_AUTOMAT_ERSTELLT = "Es wurde noch kein Automat erstellt!";
    private static final String AUTOMAT_VOLL = "Der Automat ist voll!";
    private static final String FALSCHE_AUSWAHL = "Falsche Eingabe!";
    private static final String ZU_VIELE_FLASCHEN = "Zu viele Flaschen!";

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
                "\n[3] Automat mit Flaschen befuellen" +
                "\n[4] 'erste' Flasche aus Automat nehmen" +
                "\n[5] Flasche Trinken" +
                "\n[6] Automat Ausgeben" +
                "\n[0] Zum beenden des Programms");
    }

    private int einlesenFuktion() {
        int funktion = this.input.nextInt();
        this.input.nextLine();
        return funktion;
    }

    private void ausfuehrenFunktion(int funktion) throws LagerVollException, FalscheDeklerationException {
        try {
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
                default:
                    throw new IllegalArgumentException(FALSCHE_AUSWAHL);
            }
        } catch(FalscheDeklerationException e) {
        } catch(LagerVollException e) {
        }
    }


    private void createAutomat() {
        System.out.println("Geben sie an Welchen Typ Getraenke der Automat halten soll" +
                "\n[1] Alkoholische getraenke" +
                "\n[2] Alkoholfreie getraenke" +
                "\n[3] Bier" +
                "\n[4] Wein" +
                "\n[5] Nur Rotwein" +
                "\n[6] Nur Weiswein" +
                "\n[7] Softdrinks" +
                "\n[8] Wasser" +
                "\n[9] Universeller Automat");
        int type = input.nextInt();
        System.out.println("Geben sie bitte die Kapazitaet des Automats an");
        int capacity = input.nextInt();
        input.nextLine();

        if(type < 1 || type > 9)
            throw new IllegalArgumentException(type_nicht_null);
        if(capacity <= 0)
            throw new IllegalArgumentException(Capacity_ungueltig);

        this.getraenkeautomat = new Getraenkeautomat(capacity);
        this.automatType = type;
    }

    private void deleteAutomat() {
        if(this.getraenkeautomat == null)
            throw new IllegalArgumentException(KEIN_AUTOMAT_ERSTELLT);
        System.out.println("Der automat wir entfernt");
        this.getraenkeautomat = null;
        System.out.println("Erfolgreich entfernt");
    }
    
    private void fillAutomat() throws FalscheDeklerationException, LagerVollException {
        int type;
        System.out.println("Wie viele Flaschen wollen sie einfuellen");
        int anzahl = input.nextInt();
        input.nextLine();
        if (anzahl > getraenkeautomat.getKapazitaet())
            throw new IllegalArgumentException(ZU_VIELE_FLASCHEN);
        switch (automatType) {
            case 1:
                System.out.println("Welches getraenk moechten sie in den automaten legen" +
                        "\n[1] Bier" +
                        "\n[2] Wein" +
                        "\n[3] Rotwein" +
                        "\n[4] Weiswein");
                type = input.nextInt();
                input.nextLine();
                if(type < 1 || type > 4)
                    throw new IllegalArgumentException(type_ungueltig);

                if (type == 1)
                    makeBier(anzahl);
                else if(type == 2)
                   makeWein(anzahl);
                else if(type == 3)
                    makeRotwein(anzahl);
                else if(type == 4)
                    makeWeiswein(anzahl);
                break;
            case 2:
                System.out.println("\n[1] Wasser" +
                        "\n[2] Softdrink");
                type = input.nextInt();
                input.nextLine();
                if(type < 1 || type > 2)
                    throw new IllegalArgumentException(type_ungueltig);

                if (type == 1)
                    makeWasser(anzahl);
                else if(type == 2)
                    makeSoftdrinks(anzahl);
                break;
            case 3:
                makeBier(anzahl);
                break;
            case 4:
                System.out.println("\n[1] Wein" +
                        "\n[2] Rotwein" +
                        "\n[3] Weiswein");
                type = input.nextInt();
                if(type < 1 || type > 3)
                    throw new IllegalArgumentException(type_ungueltig);

                if(type == 1)
                    makeWein(anzahl);
                else if(type == 2)
                    makeRotwein(anzahl);
                else if(type == 3)
                   makeWeiswein(anzahl);
                break;
            case 5:
                makeRotwein(anzahl);
                break;
            case 6:
                makeWeiswein(anzahl);
                break;
            case 7:
                makeSoftdrinks(anzahl);
                break;
            case 8:
                makeWasser(anzahl);
                break;
            case 9:
                System.out.println("Welches getraenk moechten sie in den Automaten legen" +
                        "\n[1] Bier" +
                        "\n[2] Wein" +
                        "\n[3] Rotwein" +
                        "\n[4] Weiswein" +
                        "\n[5] Softdrinks" +
                        "\n[6] Wasser");
                type = input.nextInt();
                input.nextLine();
                if(type < 1 || type > 6)
                    throw new IllegalArgumentException(type_ungueltig);

                if(type == 1)
                    makeBier(anzahl);
                else if (type == 2)
                    makeWein(anzahl);
                else if (type == 3)
                    makeRotwein(anzahl);
                else if (type == 4)
                    makeWeiswein(anzahl);
                else if (type == 5)
                    makeSoftdrinks(anzahl);
                else if (type == 6)
                    makeWasser(anzahl);
                break;
        }
    }

    private void delItemsAutomat() {
        if (getraenkeautomat == null)
            throw new IllegalArgumentException(KEIN_AUTOMAT_ERSTELLT);
        if (getraenkeautomat.getKapazitaet() <= 0)
            throw new IllegalArgumentException(AUTOMAT_VOLL);
        System.out.println("\nDie Flasche wird entnommen...");
        Flasche flasche = getraenkeautomat.flascheAusgeben();
        letzteFlasche = flasche;
        System.out.println(flasche + " wurde erfolgreich entnommen!");
    }

    private void drinkBottle() {
        System.out.println("Die zuletzt entnommene Flasche wird getrunken");
        letzteFlasche.leeren();
        System.out.println("Erfolgreich getrunken");
    }

    private void printAutomat() {
        if (getraenkeautomat == null)
            throw new IllegalArgumentException(KEIN_AUTOMAT_ERSTELLT);
        System.out.println(getraenkeautomat);
    }

    private void makeBier(int anzahl) throws FalscheDeklerationException, LagerVollException {
        System.out.print("Brauerei: ");
        String brauerei = input.next();
        System.out.print("Alkoholgehalt: ");
        float bierAlkoholgehalt = input.nextFloat();
        for (int i = 0; i < anzahl; i++) {
            Bier bier = new Bier(bierAlkoholgehalt, brauerei);
            Flasche<Bier> flasche = new Flasche();
            flasche.fuellen(bier);
            this.getraenkeautomat.flascheEinlegen(flasche);
        }
    }
    private void makeWein(int anzahl) throws FalscheDeklerationException, LagerVollException {
        System.out.print("Weingut: ");
        String weingut = input.next();
        System.out.print("Alkoholgehalt: ");
        float weinAlkoholgehalt = input.nextFloat();
        for (int i = 0; i < anzahl; i++) {
            Wein wein = new Wein(weinAlkoholgehalt, weingut);
            Flasche<Wein> flasche = new Flasche();
            flasche.fuellen(wein);
            this.getraenkeautomat.flascheEinlegen(flasche);
        }
    }
    private void makeRotwein(int anzahl) throws FalscheDeklerationException, LagerVollException {
        System.out.print("Weingut: ");
        String weingut = input.next();
        System.out.print("Alkoholgehalt: ");
        float weinAlkoholgehalt = input.nextFloat();
        for (int i = 0; i < anzahl; i++) {
            Rotwein rotwein = new Rotwein(weinAlkoholgehalt, weingut);
            Flasche<Wein> flasche = new Flasche();
            flasche.fuellen(rotwein);
            this.getraenkeautomat.flascheEinlegen(flasche);
        }
    }
    private void makeWeiswein(int anzahl) throws FalscheDeklerationException, LagerVollException {
        System.out.print("Weingut: ");
        String weingut = input.next();
        System.out.print("Alkoholgehalt: ");
        float weinAlkoholgehalt = input.nextFloat();
        for (int i = 0; i < anzahl; i++) {
            Weisswein weiswein = new Weisswein(weinAlkoholgehalt, weingut);
            Flasche<Weisswein> flasche = new Flasche();
            flasche.fuellen(weiswein);
            this.getraenkeautomat.flascheEinlegen(flasche);
        }
    }
    private void makeSoftdrinks(int anzahl) throws FalscheDeklerationException, LagerVollException {
        System.out.print("Hersteller: ");
        String hersteller = input.next();
        System.out.print("Zuckergehalt: ");
        float zuckergehalt = input.nextFloat();
        for (int i = 0; i < anzahl; i++) {
            Softdrink softdrink = new Softdrink(hersteller,zuckergehalt);
            Flasche<Softdrink> flasche = new Flasche();
            flasche.fuellen(softdrink);
            this.getraenkeautomat.flascheEinlegen(flasche);
        }
    }
    private void makeWasser(int anzahl) throws FalscheDeklerationException, LagerVollException {
        System.out.print("Hersteller: ");
        String hersteller = input.next();
        System.out.print("Quelle: ");
        String quelle = input.next();
        for (int i = 0; i < anzahl; i++) {
            Wasser wasser = new Wasser(hersteller, quelle);
            Flasche<Wasser> flasche = new Flasche();
            flasche.fuellen(wasser);
            this.getraenkeautomat.flascheEinlegen(flasche);
        }
    }

    public static void main(String[] args) {
        (new Dialog()).start();
    }
}