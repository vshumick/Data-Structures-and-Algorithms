public class Search2 {
    public static void main(String[] args) {

        int[] arr = new int[]{-2, 0, 3, 5, 7, 9, 11, 15, 18};
        int target = 0;

        System.out.println("ternarySearch: " + ternarySearch(arr, target));

    }
    private static int ternarySearch(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex1;
        int midIndex2;

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
        return -1;
    }

}
