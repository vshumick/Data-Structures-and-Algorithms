public class HeapSortModified2 {
    private static void siftUp(String[] arr, int index) {
        int parentIndex;
        for (; index > 0; ) {
            parentIndex = (index - 1) / 2;
            //if (arr[index] > arr[parentIndex]) {
            if (arr[index].compareTo(arr[parentIndex]) > 0) {
                swap(arr, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private static void siftDown(String[] arr, int index, int end) {
        for (; ; ) {
            int maxIndex = index;
            int indChildLeft = 2 * index + 1;
            int indChildRight = 2 * index + 2;

            //if (indChildLeft <= end && arr[maxIndex] < arr[indChildLeft]) {
            if (indChildLeft <= end && arr[maxIndex].compareTo(arr[indChildLeft]) < 0) {
                maxIndex = indChildLeft;
            }
            //if (indChildRight <= end && arr[maxIndex] < arr[indChildRight]) {
            if (indChildRight <= end && arr[maxIndex].compareTo(arr[indChildRight]) < 0) {
                maxIndex = indChildRight;
            }

            if (maxIndex == index) {
                break;
            }
            swap(arr, index, maxIndex);
            index = maxIndex;
        }
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(String[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i - 1);
        }
    }


}
