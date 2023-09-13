public class HashTransition {
    public static int hashFunction(String str, Integer[] arr) {
        int h = 0;
        for (int i = 0; i < str.length(); i++){
            h = arr[(h + str.charAt(str.length() - 1 -i)) % arr.length];
        }
        return h;
    }
}
