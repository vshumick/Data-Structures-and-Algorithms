public class HashDivisionFunc {
    public static void main(String[] args) {
        String str = "Hello";
        //myHash(str);


        //System.out.println(myHash(str));
        int key = myHash(str);
        int primeM = 691;
        System.out.println(hashFunction(key, primeM));
    }

    private static int hashFunction(int key, int primeM) {
        return key % primeM;
    }

    private static int myHash(String str) {
        int result = 0;
        for (int i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i) * mult(str.length() - i - 1);
        }
        return result;
    }

    private static int mult(int k) {
        int j = 1;
        /*if (k == 0) return 1;
        if (k == 1) return 256;*/
        for (int l = 0; l < k; l++){
            j *= 256;
        }
        return j;
    }
}
