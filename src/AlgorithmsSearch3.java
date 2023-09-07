import java.util.Arrays;

public class AlgorithmsSearch3 {
    public static void main(String[] args) {



        int[] arr = new int[]{ 0, 1, 2, 3, 4, 5};
                /*{ -2, 0, 3, 5, 7, 9, 11, 15, 18}*/;
        //int[] arr = new int[]{ 5, 0, -2, 7, 3};
        ///////////////////////0  1  2  3  4  5  6  7  8
        //int target = 5;
        //System.out.println("binarySearch: " + binarySearch(arr, target));

        //System.out.println("interpolationSearch: " + interpolationSearch(arr, target));

        /*System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));*/



        //narayanMethod(arr);

        System.out.println(Arrays.toString(arr));


        int ind = 4;
        for (int k = ind; k <= ind + (arr.length - ind - 1) / 2; k++) {
                swap(arr, k, (arr.length - 1) - k + ind);
            }

        System.out.println(Arrays.toString(arr));




    }


    private static void narayanMethod(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for (;;) {
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
            /*for (int k = ind + 1; k < (arr.length - ind - 1) / 2; k++) {
                swap(arr, k, (arr.length - 1) - k + ind);
            }*/
            for (int s = ind + 1, e = arr.length -1; s < e; s++, e--) {
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


    private static void selectSort(int[] arr) {
        int min;
        int minInd;
        int buff;
        //int selected;
        for(int i=0; i<arr.length; i++){
            //selected = arr[i];
            min = arr[i];
            minInd = i;
            for(int j=i+1; j<arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    minInd = j;
                }
            }
            buff = arr[i];
            arr[i] = min;
            arr[minInd] = buff;
        }
    }

    private static int interpolationSearch(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex;
        int result = -1;
        while (leftIndex <= rightIndex) {
            //midIndex = (leftIndex + rightIndex) / 2;
            if (arr[leftIndex] == arr[rightIndex]){
                break;
            }
            midIndex = (target - arr[leftIndex])*(leftIndex-rightIndex)/
                       (arr[leftIndex]-arr[rightIndex])+leftIndex;
            if (arr[midIndex] == target) {
                return midIndex;
            } else if (target < arr[midIndex]) {
                rightIndex = midIndex - 1;
            } else /*if (target > arr[midIndex])*/ {
                leftIndex = midIndex + 1;
            }
        }
        if (arr[leftIndex] == target){
            return leftIndex;
        }

            return result;
    }

    private static int ternarySearch(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex1;
        int midIndex2;
        int result = -1;
        while (leftIndex <= rightIndex) {
            midIndex1 = leftIndex + (rightIndex - leftIndex) / 3;
            midIndex2 = leftIndex + (rightIndex - leftIndex) *2 / 3;
            if (arr[midIndex1] == target) {
                return midIndex1;
            } else if (target < arr[midIndex1]) {
                rightIndex = midIndex1 - 1;
            } else if (target == arr[midIndex2]) {
                return midIndex2;
            } else if (target < arr[midIndex2]) {
                leftIndex = midIndex1 + 1;
                rightIndex = midIndex2 - 1;
            } else if (target > arr[midIndex2]) {
                leftIndex = midIndex2 + 1;
            }
        }
        return result;
    }

    private static int linearSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
