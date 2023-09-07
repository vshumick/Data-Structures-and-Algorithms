import java.util.*;

/**
 * Created by Viktor on 14.11.2017.
 */
public class Test17 {
    public static void main(String[] args) {
        Map<Integer, Collection> mp = new HashMap<>();

        mp.put(1, new HashSet());

        List<Number> ls = new ArrayList();
        Number i = 10;
        ls.add(i);

        System.out.println(ls.toString());
    }

    public void meth1(List<? extends Number> par1) {

    }

    public void printtttt(Set<String> strSet) {
    }
    //public void printtttt(Set<Integer> intSet) { }

}

