import java.util.ArrayList;

public class Search {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"Cat1", "Cat2", "Cat3", "Cat4", "Cat5", "Cat6", "Cat7", "Cat8",
                                    "Cat9", "Cat10"};
        String target = "Cat3";

        //System.out.println("linearSearch: " + linearSearch(arr1, target));
        ////////////////////////////////////////////////////////////////////

        int[] arr2 = /*new int[]*/{-2, 0, 3, 5, 7, 9, 11, 15, 18};
        ////////////////////////0  1  2  3  4  5  6   7   8
        int target2 = 7;
        //System.out.println("binarySearch: " + binarySearch(arr2, target2));

        //System.out.println("ternarySearch: " + ternarySearch(arr2, target2));

        System.out.println("interpolationSearch: " + interpolationSearch(arr2, target2));



    }
    /* Линейный поиск (Linear Search) -----------------------------------------------------------------------
       Сложность: O(n)

     */
    private static int linearSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /* Модифицированный линейный поиск (Linear Search Modified) -----------------------------------------------
     */
    public static int linearSearchModified(ArrayList<Integer> sequince, int element) {
        sequince.add(element);
        int lastIndex = sequince.size() - 1;
        int i = 0;
        for (; sequince.get(i) != element;) {
            i++;
        }
        sequince.remove(lastIndex);
        if (i != lastIndex) {
            return i;
        }
        return -1;
    }

    /* Бинарный поиск (Binary Search) -------------------------------------------------------------------------
       Сложность: O(log n)

     */
    private static int binarySearch(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex;
        int result = -1;
        while (leftIndex <= rightIndex) {
            midIndex = (leftIndex + rightIndex) / 2;
            if (arr[midIndex] == target) {
                return midIndex;
            } else if (target < arr[midIndex]) {
                rightIndex = midIndex - 1;
            } else /*if (target > arr[midIndex])*/ {
                leftIndex = midIndex + 1;
            }
        }
            return result;
    }

    /* Тернарный поиск (Ternary Search) -----------------------------------------------------------------------
       Сложность: O(log n)

     */
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

    /* Интерполяционный поиск (Interpolation Search) ----------------------------------------------------------
       Сложность: O(n)

       Идея: за основу берем формулу (x-x1)/(x1-x2) = (y-y1)/(y1-y2) => i(K) = (K-K[l])(l-r)/(K[l]-K[r]) + l
     */
    private static int interpolationSearch(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex;
        int result = -1;
        while (leftIndex <= rightIndex) {
            if (arr[leftIndex] == arr[rightIndex]){
                break;
            }
            midIndex = (target - arr[leftIndex])*(leftIndex-rightIndex)/
                    (arr[leftIndex]-arr[rightIndex])+leftIndex;
            if (arr[midIndex] == target) {
                return midIndex;
            } else if (target < arr[midIndex]) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }
        if (arr[leftIndex] == target){
            return leftIndex;
        }

        return result;
    }


}
