import java.util.HashMap;

public class Test37 {

    private HashMap<Integer, Integer> solveSubtask = new HashMap<>();

    public int cutRod(int[] p, int n) {
        return findMaxProfit(p, n);
    }

    private int findMaxProfit(int[] p, int n) {
        if (n == 0) {
            return 0;
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int lastPartProfit;
            if (solveSubtask.containsKey(n - i)) {
                lastPartProfit = solveSubtask.get(n - i);
            } else {
                lastPartProfit = findMaxProfit(p, n - i);
                solveSubtask.put(n - i, lastPartProfit);
            }

            maxProfit = Math.max(maxProfit, p[i] + lastPartProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] p = {0, 1, 5, 8, 9};
        int n = 4;

        Test37 solution = new Test37();
        System.out.println(solution.cutRod(p, n));  // It should print 10
    }
}
