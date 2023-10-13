public class Test39 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 10, 20, 30};
        int searchValue = 30;

        System.out.println(binarySearch(arr, searchValue));

    }

    private static int binarySearch(int[] arr, int val) {
        return binarySearch(arr, val, 0, arr.length - 1);
    }
    private static int binarySearch(int[] arr, int val, int left, int right) {
        int res = -1;
        if(arr == null || arr.length == 0 || arr[left] > val || arr[right] < val || left > right){
            return res;
        }

        int mid = left + (right - left)/2;
        if (arr[mid] == val){
            return mid;
        }
        if(val < arr[mid]){
            res = binarySearch(arr, val, left, mid - 1);
        }
        if(val > mid){
            res = binarySearch(arr, val, mid + 1, right);
        }

        return res;
    }


}
