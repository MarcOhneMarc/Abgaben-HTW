import java.sql.Array;
import java.util.Arrays;

public class testDialog {
    private DoppeltVerketteteListe DVL;

    public static void main(String[] args){
        DoppeltVerketteteListe<String> test = new DoppeltVerketteteListe<String>();
        DoppeltVerketteteListe<String> test2 = new DoppeltVerketteteListe<String>();

        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        test2.addAll(test);
        System.out.println(test2.toString());
    }
}
