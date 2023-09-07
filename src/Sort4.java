import java.util.Arrays;
import java.util.Random;

public class Sort4 {
    public static void main(String[] args) {
        int arrLength = 100;
        int min = 0;
        int max = 1000;

        int[] arr = new int[arrLength];
        fillRandomArray(arr, min, max);

        System.out.println(Arrays.toString(arr));
        long timeStart = System.currentTimeMillis();

        //quickSort(arr);
        quickSortMixed(arr);

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - timeStart));
        System.out.println(Arrays.toString(arr));

    }

    private static void insertionSortPartly(int[] arr, int begin, int end) {
        for (int i = 1 + begin; i < end + 1; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (arr[j - 1] <= temp) {
                    break;
                }
                arr[j] = arr[j - 1];

            }
            arr[j] = temp;
        }
    }

    public static int breakPartition(int[] array, int lo, int hi) {
        int i = lo + 1;
        int supportElement = array[lo];
        int j = hi;
        for (;;) {
            for (; i < hi && array[i] < supportElement;) {
                i += 1;
            }
            for (; array[j] > supportElement;) {
                j -= 1;
            }
            if (i >= j) {
                break;
            }
            swap(array, i++, j--);
        }
        swap(array, lo, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSortMixed(int[] array) {
        quickSortMixed(array, 0, array.length - 1);
    }

    public static void quickSortMixed(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int h = breakPartition(array, lo, hi);
        if (hi - lo > 32) {
            quickSortMixed(array, lo, h - 1);
        } else {
            insertionSortPartly(array, lo, h - 1);
        }
        if (hi - h + 1 > 32) {
            quickSortMixed(array, h + 1, hi);
        } else {
            insertionSortPartly(array, h + 1, hi);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void fillRandomArray(int[] arr, int min, int max) {
        int randomNum;
        Random rn = new Random();
        for (int i=0; i < arr.length; i++){
            randomNum =  rn.nextInt((max - min) + 1) + min;
            arr[i] = randomNum;
        }
    }


}
