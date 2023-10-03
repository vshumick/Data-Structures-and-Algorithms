import java.util.Set;
import java.util.TreeSet;

public class Test38 {
    public static void main(String[] args) {
        String str = "asasdg";
        str.hashCode();

        Set set = new TreeSet();

        int n = 15;
        int h = (int) Math.ceil(Math.log(n+1)/Math.log(2) - 1);

        System.out.println("h: " + h);

    }
}
