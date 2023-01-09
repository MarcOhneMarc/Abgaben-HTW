public class testdialog {

    public ArrayFunctions arrayFunctions;
    public Mittelwert mittelwert;

    public void getcall(){
        mittelwert.getMittelwert();
    }

    public static void main(String[] args){

        double[] testa = {1, 1, 1,1,1,1,1,1,1,1,1,1,3, 3, 3, 3,4,4,4,4,5,5,5,6,6};
        Mittelwert atze = ArrayFunctions.berechneMittelwert(testa);
        testdialog test = new testdialog();

        System.out.println("Mittelwert: " + atze.getMittelwert());
        System.out.println("Max: " + atze.getMax());
        System.out.println("Min: " +atze.getMin());
        
        String[] test = {"Hueb", "KEK", "low"};
        System.out.println(ArrayFunctions.stringsAuswerten(test));

    }
}
