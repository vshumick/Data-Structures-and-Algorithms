import java.util.HashMap;
import java.util.Map;

public class AlgorithmsRecurcy {
    static Map<Integer, Long> mem = new HashMap();
    public static void main(String[] args) {


        System.out.println(sequenceFibonacci(47));
        System.out.println(sequenceFibonacciMemoized(100));

    }

    private static long sequenceFibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        return sequenceFibonacci(n - 2) + sequenceFibonacci(n - 1);
    }

    private static long sequenceFibonacciMemoized(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        Long result = mem.get(n);

        if (result != null)
            return result;

        result = sequenceFibonacciMemoized(n - 2) + sequenceFibonacciMemoized(n - 1);
        mem.put(n, result);

        return result;
    }

}
