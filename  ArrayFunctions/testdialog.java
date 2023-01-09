public class testdialog {

    public ArrayFunctions arrayFunctions;
    public Mittelwert mittelwert;

    public static void main(String[] args){

        //double[] testa = {155, 183, 175, 175, 188, 187, 190, 168, 160, 183};
        double[] testa = {10, 5, 5, 5, 0};
        Mittelwert atze = ArrayFunctions.berechneMittelwert(testa);

        System.out.println(atze.getMittelwert());

    }
}