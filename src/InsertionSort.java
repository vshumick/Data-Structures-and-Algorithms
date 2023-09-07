import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) throws InterruptedException {
        int arrLength = 10;
        int min = 0;
        int max = 10;

        /*int[] arr = new int[arrLength];
        MyArrayUtils.fillRandomArray(arr, min, max);*/
        int[] arr = new int[]//{1, 4, 5, 5, 5, 6, 7, 7, 7, 8};
                        //{8, 4, 5, 7, 5, 5, 1, 7, 7, 6};
                {4, 6, 4, 3, 7, 0, 2, 2, 1, 0};

        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------------");
        /////////////////////////////////////////////////////////////////////////////////
        long timeStart = System.currentTimeMillis();
        for(int i=0; i<arr.length; i++){
            int j=i;
            while (j>0 && arr[j-1]>arr[j]){
                MyArrayUtils.swap(arr, j-1, j);
                j = j-1;
                System.out.println(Arrays.toString(arr));
            }
        }
        //Thread.sleep(400);
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - timeStart));

        System.out.println(Arrays.toString(arr));


    }
}
