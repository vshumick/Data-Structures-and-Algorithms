import java.util.HashMap;
import java.util.Map;

public class Task14_1 {
    static int count = 0;
    static Map map = new HashMap();
    public static void main(String[] args) {
        int[][] arr = { {0},
                        {5,8},
                        {9,8,2},
                        {1,3,5,6},
                        {6,2,4,4,5},
                        {9,5,3,5,5,7},
                        {7,4,6,4,7,6,8},
                        {1,5,5,7,9,0,8,1},
                        {1,5,5,7,9,0,8,1,2}
                      };

        //System.out.println(rec(arr, 0, 0));
        System.out.println(rec(arr, 7, 6));

    }






    public static int rec(int[][] arr, int i, int j){
        if (i == arr.length - 1) return arr[i][j];

        if (map.containsKey(i + "," + j)) {
            return (int) map.get(i + "," + j);
        }
        count++;
        int res = arr[i][j] + Math.max(rec(arr, i + 1, j), rec(arr, i + 1, j + 1));
        map.put(i + "," + j, res);
        return res;
    }
}
