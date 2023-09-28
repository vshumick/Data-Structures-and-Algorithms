import java.util.Arrays;

public class Task14_2 {
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

        int[][] res = getMaxGold(arr);

        for(int[] arr2 :res)
            System.out.println(Arrays.toString(arr2));

        System.out.println(getMaxValue(res));


    }

    public static int[][] getMaxGold(int[][] arr){
        int[][] res = new int[arr[arr.length - 1].length][arr[arr.length - 1].length];
        for(int i = 1; i < arr.length; i++){
            res[i][0] = arr[i][0] + res[i-1][0];
            for (int j=1; j < arr[i].length; j++){
                res[i][j] = arr[i][j] + Math.max(res[i-1][j], res[i-1][j-1]);
            }
        }

        return res;
    }

    public static int getMaxValue(int[][] arr){
        int[] arr1 = arr[arr.length - 1];
        int res = arr1[0];
        for(int val : arr1){
            if(val > res)
                res = val;
        }
        return res;
    }
}
