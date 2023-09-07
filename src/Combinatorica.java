import java.util.Arrays;

public class Combinatorica {
    public static void main(String[] args) {
        //int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] number = new int[]{0, 1, 2, 3, 4};
        int k = 3;
        int[] perm = Arrays.copyOfRange(number, 0, k);


        //permutationGenerator(4);
        //printAllCombination(5, 3);


        int cnt = 1;
        for (; perm != null;) {
            System.out.print((cnt++) + ": ");
            System.out.println(Arrays.toString(perm));
            perm = getNextKPermutation(k, number);
        }


    }
    //------------------------------------------------------------------------------------------------------------------
    //Реализация алгоримта Нарайаны
    public static void permutationGenerator(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int index = findMaxIndex(arr);
        for (; index != -1;) {
            int element = arr[index];
            int swapIndex = findIndexBiggerElement(arr, element);
            swap(arr, index, swapIndex);
            reverse(arr, index);
            System.out.println(Arrays.toString(arr));
            index = findMaxIndex(arr);
        }
    }

    public static int findMaxIndex(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexBiggerElement(int[] arr, int element) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > element) {
                return i;
            }
        }
        return -1;
    }

    public static void reverse(int[] arr, int index) {
        for (int i = 0; i < (arr.length - index - 1) / 2; i++) {
            swap(arr, index + 1 + i,  arr.length - i - 1);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void printAllCombination(int n, int k) {
        int[] comb = new int[k + 2];
        for (int i = 0; i < k; i++) {
            comb[i] = i;
        }
        comb[k] = n;
        comb[k + 1] = 0;
        int cnt = 1;
        for (;;) {
            printArrayPart(comb, 0, k, cnt++);
            int j = 0;
            for (; comb[j] + 1 == comb[j + 1];) {
                comb[j] = j;
                j = j + 1;
            }
            if (j < k) {
                comb[j]++;
            } else {
                break;
            }
        }
    }

    public static void printArrayPart(int[] array, int s, int e, int cnt) {
        System.out.print(cnt + ": [");
        for (int i = s; i < e - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[e - 1] + "]");
    }

    //------------------------------------------------------------------------------------------------------------------

    public static int[] getNextKPermutation(int k, int[] number) {
        int n = number.length;
        int i = k;
        for (; i < n && number[i] < number[k - 1];) {
            i = i + 1;
        }
        if (i < n) {
            swap(number, i, k - 1);
        } else {
            reverse(number, k - 1);
            int j = k - 2;
            for (; j >= 0 && number[j] > number[j + 1];) {
                j = j - 1;
            }
            if (j < 0) {
                return null;
            } else {
                i = n - 1;
                for (; i > j;) {
                    if (number[i] > number[j]) {
                        break;
                    }
                    i = i - 1;
                }
                swap(number, i, j);
                reverse(number, j);
            }
        }
        return Arrays.copyOfRange(number, 0, k);
    }



    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
