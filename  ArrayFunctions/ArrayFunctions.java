public class ArrayFunctions {

    private ArrayFunctions() {
    }

    public static Mittelwert berechneMittelwert(double[] messwerte){

        double sum = 0;
        double min = messwerte[0];
        double max = 0;

        for(int i = 0; i < messwerte.length; i++){
            sum = sum + messwerte[i];
            if (messwerte[i] > max){
                max = messwerte[i];
            } else if (messwerte[i] < min) {
                min = messwerte[i];
            }
        }

        System.out.println((sum/messwerte.length)+ " " +max + " " +min);
        Mittelwert rueckgabe = new Mittelwert((sum/messwerte.length),max,min);

        return rueckgabe;
    }
}
