import java.util.Arrays;

public class Homework13 {
    public static void main(String[] args) {
        int[] arr = {5, 0, -2, 7, 2};
        System.out.println(Arrays.toString(arr));
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
