import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Sort {
    public static void main(String[] args) {
        int arrLength = 1000000;
        int min = 0;
        int max = 1000;

        int[] arr = new int[arrLength];
        fillRandomArray(arr, min, max);

        String[] arrStr = new String[arrLength];
        fillRandomArrayString(arrStr, 10);


        /*int[] arr = new int[]//{ 5, 0, -2, 7, 3}
                             //{8, 4, 5, 7, 5, 5, 1, 7, 7, 6}
                             //{1, 2, 4, 8, 10}
                             //{}
                             //{1,1,1}
                             //{1,1,1,1}
                             {3,2,2}
                ;*/

        //System.out.println(Arrays.toString(arr));

        //System.out.println(Arrays.toString(merge(arr, 0,4,5, 9)));

        //System.out.println(Arrays.toString(arr));
        long timeStart = System.currentTimeMillis();

        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //shakerSort(arr);
        //mergeSort(arr);
        //quickSort(arr);
        //insertionSortPartly(arr, 0, arr.length - 1);
        //quickSort(arr);
        //quickSortMixed(arr);
        //selectionSortRecursive(arr);
        //quickSortCircular(arr);
        //mergeSortRecurcy(arr);
        //HeapSort.heapSort(arr);

        //HeapSortModified.heapSort(arr);
        HeapSortModified2.heapSort(arrStr);

        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(arrStr));

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - timeStart));
        //System.out.println(Arrays.toString(arr));




    }

    /*Пузырьковая сортировка (Bubble Sort) -------------------------------------------------------------------
    Сложность: O(n2)

     */
    private static void bubbleSort(int[] arr) {
        int buffer;
        boolean swap = false;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }

        }
    }

    /*Сортировка выбором (Selection Sort) --------------------------------------------------------------------
    Сложность: O(n2)

     */
    private static void selectionSort(int[] arr) {
        int min;
        int minInd;
        int buff;

        for(int i=0; i<arr.length; i++){
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

    /*Сортировка выбором рекурсивная (Selection Sort Recursive) -----------------------------------------------
    Сложность: O(n2)

     */

    private static void selectionSortRecursive(int[] arr, int index) {
        int min;
        int minInd;

        if (index == arr.length - 1){
            return;
        }
        min = arr[index];
        minInd = index;

        for(int j=index+1; j<arr.length; j++){
            if (arr[j] < min){
                min = arr[j];
                minInd = j;
            }
        }
        swap(arr, index, minInd);

        selectionSortRecursive(arr, index+1);
    }
    private static void selectionSortRecursive(int[] arr) {
        selectionSortRecursive(arr, 0);
    }


    /*Сортировка вставками (Insertion Sort) ------------------------------------------------------------------
    Сложность: O(n2)

     */

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
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

    /*Сортировка перемешиванием (Shaker Sort) -------------------------------------------------------------------
     Сложность: O(n2)

      */
    private static void shakerSort(int[] arr) {
        int buffer;
        boolean sorted = true;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
            for (int j =arr.length - 2 - i; j > i; j--) {
                if (arr[j] < arr[j-1]){
                    buffer = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = buffer;
                }

            }

        }
    }

    /*Сортировка слиянием (Merge Sort) -------------------------------------------------------------------
     Сложность: O(n·ln(n))

     */
    private static void mergeSort(int[] array) {
        int n = array.length;
        for (int size = 1; size < n; size *= 2) {
            for (int j = 0; j < n - size; j += 2 * size) {
                merge(array, j, j + size - 1, j + size, Math.min(j + 2 * size - 1, n - 1));
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //Вспомагательный метод для Сортировки слиянием (Merge Sort)
    private static void merge(int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int[] supportArray = Arrays.copyOf(array, array.length);
        for (int i = leftStart; i <= rightEnd; i++) {
            supportArray[i] = array[i];
        }
        int l = leftStart;
        int r = rightStart;
        for (int i = leftStart; i <= rightEnd; i++) {
            if (l > leftEnd) {
                array[i] = supportArray[r];
                r ++;
            } else if (r > rightEnd) {
                array[i] = supportArray[l];
                l ++;
            } else if (supportArray[l] < supportArray[r]) {
                array[i] = supportArray[l];
                l ++;
            } else {
                array[i] = supportArray[r];
                r ++;
            }
        }
    }

    /*private static int[] merge(int[] arr, int firstPartIndStart, int firstPartIndEnd,
                               int secondPartIndStart, int secondPartIndEnd) {
        int newArray[] = new int[secondPartIndEnd - firstPartIndStart + 1];
        int indexLeft = firstPartIndStart;
        int indexRight = secondPartIndStart;

        for (int i = 0; i < newArray.length; i++) {

            if (indexLeft > firstPartIndEnd) {
                newArray[i] = arr[indexRight];
                indexRight++;
            } else if (indexRight > secondPartIndEnd) {
                newArray[i] = arr[indexLeft];
                indexLeft++;
            } else if (arr[indexLeft] < arr[indexRight]) {
                newArray[i] = arr[indexLeft];
                indexLeft++;
            } else if (arr[indexLeft] >= arr[indexRight]) {
                newArray[i] = arr[indexRight];
                indexRight++;
            }
        }
        return newArray;
    }*/

/*    private static int[] mergeSort(int[] arr) {
        int block_size = 1;

        while (block_size < arr.length) {
            for(int i=0; i<arr.length - block_size; block_size *= 2) {
                int first_part_ind_start = i;
                int first_part_ind_end = i + block_size - 1;
                int second_part_ind_start = i + block_size;
                int second_part_ind_end = Math.min(i + 2 * block_size - 1, arr.length - 1);
                int[] temp_array = merge(
                        arr, first_part_ind_start, first_part_ind_end, second_part_ind_start, second_part_ind_end);
                //arr[first_part_ind_start:second_part_ind_end + 1] =temp_array;
                for (int j = 0; j < second_part_ind_end - first_part_ind_start + 1; j++){
                    arr[first_part_ind_start + j]=temp_array[j];
                }
                //int[] supportArray = Arrays.copyOf(array, array.length);

                //block_size = block_size * 2;
            }
        }

        return arr;
    }*/
    /*Сортировка слиянием рекурсивная (Merge Sort Recurcy) -------------------------------------------------------------------
     Сложность: O(n·ln(n))

     */
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

    /*Быстрая сортировка (Quick Sort) -------------------------------------------------------------------
     Сложность: O(n·ln(n))

     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int h = breakPartition(array, lo, hi);
        quickSort(array, lo, h - 1);
        quickSort(array, h + 1, hi);
    }

    /*private static void quickSort(int[] arr, int left, int right) {
        //left = 0;
        //right = arr.length-1;
        if (right - left <= 1) {
            return;
        }
        int mid = hoareParts(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }*/

    /*Быстрая сортировка рекурсией (Quick Sort Recurcy) -------------------------------------------------------------------
     Сложность: O(n·ln(n))

     */
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
    //Вспомагательный метод для быстрой сортировки (Quick Sort)
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
    //-------------------------------------------------------------------------------------------------------
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*private static int hoareParts(int[] arr, int left, int right) {

        int supportElement = arr[left];
        int i = left + 1;
        int j = right;
        for (; ; ) {
            for (; i < right; i++) {
                if (arr[i] > supportElement) {
                    break;
                }
            }
            for (; j > i; j--) {
                if (arr[j] < supportElement) {
                    break;
                }
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else {
                int temp = arr[j];
                arr[j] = supportElement;
                arr[left] = temp;
                return j;
            }
        }

    }*/

    /*Быстрая сортировка (Quick Sort) -------------------------------------------------------------------
  Сложность: O(n·ln(n))

  */
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

    private static void fillRandomArrayString(String[] arr, int stringLength) {
        for (int i=0; i < arr.length; i++){
            arr[i] = randGeneratedStr(stringLength);
        }
    }
    static String randGeneratedStr(int l) {

        // a list of characters to choose from in form of a string
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        // creating a StringBuffer size of AlphaNumericStr
        StringBuilder s = new StringBuilder(l);
        int i;
        for (i = 0; i < l; i++) {
            //generating a random number using math.random()
            int ch = (int) (AlphaNumericStr.length() * Math.random());
            //adding Random character one by one at the end of s
            s.append(AlphaNumericStr.charAt(ch));
        }
        return s.toString();
    }


}
