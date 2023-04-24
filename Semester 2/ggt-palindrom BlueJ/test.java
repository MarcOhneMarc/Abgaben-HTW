public class test {
    public Palindrom palindrom;

    public static void main(String[] args){
        Palindrom palindromRe = new PalindromRekursiv();
        Palindrom palindromIt = new PalindromIterativ();

        System.out.println(System.nanoTime());
    }
}
