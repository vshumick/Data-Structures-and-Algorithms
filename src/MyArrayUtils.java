import java.util.Random;

public class MyArrayUtils {
    static void fillRandomArray(int[] arr, int min, int max) {
        int randomNum;
        Random rn = new Random();
        for (int i=0; i < arr.length; i++){
            randomNum =  rn.nextInt((max - min) + 1) + min;
            arr[i] = randomNum;
        }
        //Arrays.sort(arr);
    }
    static void swap(int[] arr, int i, int j){
      int buff;
      buff = arr[i];
      arr[i] = arr[j];
      arr[j] = buff;
    }
}
