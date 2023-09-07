import java.util.Arrays;

public class Combinatorica4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        narayanMethod(arr);
    }
    private static void narayanMethod(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for (; ; ) {
            int ind = -1;
            //1
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] < arr[i + 1]) {
                    ind = i;
                    break;
                }
            }
            if (ind == -1) {
                return;
            }

            //2, 3
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[j] > arr[ind]) {
                    swap(arr, j, ind);
                    break;
                }
            }

            //4
            for (int s = ind + 1, e = arr.length - 1; s < e; s++, e--) {
                swap(arr, s, e);
            }

            System.out.println(Arrays.toString(arr));

        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
