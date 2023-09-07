import java.util.Arrays;
import java.util.stream.IntStream;

public class AlgorithmsCombinatorica5 {
    private static int cnt = 1;

    public static void main(String[] args) {
        String[] words = {"Kaznit'", "nel'zya", "pomilovat'", "no", "mozhno"};

        allWordPermutations(words);

    }
    //------------------------------------------------------------------------------------------------------------------
    //Использование алгоримта Нарайаны
    public static void allWordPermutations(String[] words) {

        int[] arr = IntStream.range(0, words.length).toArray();

        int cnt = 1;
        putInOrder(words, arr);
        int index = findMaxIndex(arr);
        for (; index != -1;) {
            int element = arr[index];
            int swapIndex = findIndexBiggerElement(arr, element);
            swap(arr, index, swapIndex);
            reverse(arr, index);
            putInOrder(words, arr);
            index = findMaxIndex(arr);
        }
    }

    private static void putInOrder(String[] words, int[] arr) {
        String[] wordsCopy = new String[words.length];
        for(int i=0; i < words.length; i++){
            wordsCopy[i] = words[arr[i]];
        }

        System.out.println((cnt++) + ": " + Arrays.toString(wordsCopy));

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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
