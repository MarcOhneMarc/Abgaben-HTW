public class MathDialog {
    private MathFunctions mathFunctions;

    public static void main(String[] args){
        System.out.println(MathFunctions.berechneNullstellen(2.5 , 1.5));
        System.out.println(MathFunctions.berechneNullstellen(3 , 2.35));
        System.out.println(MathFunctions.berechneNullstellen(1.5 , 2.5));
        System.out.println(MathFunctions.berechneGgt(5 , 10));
    }
}
