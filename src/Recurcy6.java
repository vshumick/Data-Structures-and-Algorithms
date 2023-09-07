import java.util.Arrays;
import java.util.Stack;

public class Recurcy6 {

    public static void main(String[] args) {

        int[] arr = //{8, 4, 5, 7, 5, 5, 1, 7, 7, 6};
                   //0  1  2  3  4  5  6  7  8  9
                {0, 0, 2, 0, 0, 0, 0, 1, 0, 1};
                //{1, 3, 2};
        System.out.println(Arrays.toString(arr));
        quickSortCircular(arr);
        //mergeSortRecurcy(arr);

        System.out.println(Arrays.toString(arr));

    }

    //Quick Sort Circular --------------------------------------------------------------------------------------------------------
    public static void quickSortCircular(int[] arr) {
        if (arr.length > 1) {
            quickSortCircular(arr, 0, arr.length - 1);
        }
    }

    public static void quickSortCircular(int[] arr, int lo, int hi) {
        Stack<int[]> stack = new Stack() ;
        stack.push(new int[]{lo, hi});

        int[] interval;

        while (!stack.isEmpty()) {
            interval = stack.pop();
            int h = breakPartition(arr, interval[0], interval[1]);
                if (interval[1] - h > 1)
                    stack.push(new int[]{h + 1, interval[1]});
                if (h - interval[0] > 1)
                    stack.push(new int[]{interval[0], h - 1});
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int breakPartition(int[] arr, int lo, int hi) {
        int i = lo + 1;
        int supportElement = arr[lo];
        int j = hi;
        for (;;) {
            for (; i < hi && arr[i] < supportElement;) {
                i += 1;
            }
            for (; arr[j] > supportElement;) {
                j -= 1;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i++, j--);
        }
        swap(arr, lo, j);
        return j;
    }

    //Merge Sort Recurcy --------------------------------------------------------------------------------------------------------
    public static void mergeSortRecurcy(int[] arr) {
        if (arr.length > 1) {
            mergeSortRecurcy(arr, 0, arr.length - 1);
        }

    }

    public static void mergeSortRecurcy(int[] arr, int start, int end) {

        if (start == end) // выход из рекурсии - массив из 1 элемента отсортирован по определению
            return;

        int mid = (start + end)/2; //

        mergeSortRecurcy(arr, start  , mid);    // сортировка 1-й половины массива
        mergeSortRecurcy(arr,mid + 1, end); // сортировка 2-й половины массива
        merge(arr, start, end);
    }

    public static void merge(int[] arr, int start, int end) {
        int mid = (start + end)/2;
        int[] supportArray = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while ((i <= mid) || (j <= end)) {
            if (i > mid) {
                supportArray[k++] = arr[j++];
                continue;
            }
            if (j > end) {
                supportArray[k++] = arr[i++];
                continue;
            }
            if (arr[i] < arr[j]) {
                supportArray[k++] = arr[i++];
                continue;
            } else {
                supportArray[k++] = arr[j++];
                continue;
            }
        }
        for (int ii = 0; ii < end - start + 1; ii++) {
            arr[start + ii] = supportArray[ii];
        }
    }
    //-------------------------------------------------------------------------------------------------------
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
