import java.sql.Array;
import java.util.Arrays;

public class testDialog {
    private DoppeltVerketteteListe DVL;

    public static void main(String[] args){
        DoppeltVerketteteListe<String> test = new DoppeltVerketteteListe<String>();

        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        System.out.println(test.size());
        String[] testa = new String[test.size()];
        test.toArray(testa);
        System.out.println(Arrays.toString(testa));
        System.out.println(test.indexOf("test2"));
    }
}
