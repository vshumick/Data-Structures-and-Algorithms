import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test32 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 10, 20};
        ArrayList lst = new ArrayList();
        lst.add("1");
        lst.add("2");
        lst.add("3");
        lst.add("4");
        lst.add("5");

        System.out.println(Arrays.toString(arr));
        System.out.println(lst);

        List ls = Arrays.asList(arr, arr);
        List ls2 = Arrays.asList(1, 2, 33, 44, 55);

        System.out.println(ls);
        System.out.println(ls2);

    }
}
