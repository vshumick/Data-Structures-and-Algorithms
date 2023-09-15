public class Test34 {
    public static void main(String[] args) {
        System.out.println(myPow(7302757, 5));

        //System.out.println(Math.floor(Math.random()*16));

       /* int key1 = key("one");
        System.out.println("k: " + getKey(key1));*/

    }

    private static long myPow(int value, int degree) {
        long j = 1;
        for (int l = 0; l < degree; l++) {
            j *= value;
        }
        return j;
    }

    static int key(String str) {
        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i) * myPow(256, str.length() - 1 - i);
        }
        return res;
    }

    static int getKey(int key) {
        int capacity = 2;
        int[] arr = {1, 0, 1, 0, 1};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * Math.floor(myPow(key, i));
        }
        return sum % capacity;
    }
}
