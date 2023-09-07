public class Test27 {
    public static void main(String[] args) {
        String[] arr = new String[]
                {"Cat1", "Cat2", "Cat3", "Cat4", "Cat5", "Cat6", "Cat7", "Cat8", "Cat9", "Cat10"};

        String target = "Cat1";

        System.out.println(catSearch(arr, target));


    }

    private static int catSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
