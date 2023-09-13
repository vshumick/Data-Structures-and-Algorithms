import java.util.HashMap;

public class Test33 {
    public static void main(String[] args) {

        int capacity = 9999999;


        for(int i = capacity; i <= 100000000; i ++){
            boolean isPrime = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                System.out.println(i);
                return;
            }
        }

    }



}
