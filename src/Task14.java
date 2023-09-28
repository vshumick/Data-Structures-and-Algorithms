import java.util.Arrays;

public class Task14 {
    public static void main(String[] args) {
        int[] arr = {5, 0, -2, 7, 2};
        System.out.println(Arrays.toString(arr));

        HeapSortModified.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
