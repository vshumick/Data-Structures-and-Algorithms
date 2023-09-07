import java.util.Arrays;

public class Test28 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[3] = 18;
        System.out.println(Arrays.toString(arr));

        System.out.println("------------------------------");

        int twoD[][]= new int[4] [5];
        int i , j , k = 0;
        for(i=0; i<4; i++)
            for(j=0; j<5; j++) {
                twoD[i][j] = k ;
                k++;
            }
        /*for(i=0; i<4; i++) {
            for(j=0; j <5; j++)
                System.out.print(twoD[i][j] + " ");
            System.out.println();
        }*/
        for(int[] arrOneD: twoD){
            for(int val: arrOneD){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
