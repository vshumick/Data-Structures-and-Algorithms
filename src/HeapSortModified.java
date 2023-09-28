public class HeapSortModified {
    private static void siftUp(int[] arr, int index) {
        int parentIndex;
        for (; index > 0; ) {
            parentIndex = (index - 1) / 2;
            if (arr[index] > arr[parentIndex]) {
                swap(arr, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private static void siftDown(int[] arr, int index, int end) {
        for (; ; ) {
            int maxIndex = index;
            int indChildLeft = 2 * index + 1;
            int indChildRight = 2 * index + 2;

            if (indChildLeft <= end && arr[maxIndex] < arr[indChildLeft]) {
                maxIndex = indChildLeft;
            }
            if (indChildRight <= end && arr[maxIndex] < arr[indChildRight]) {
                maxIndex = indChildRight;
            }

            if (maxIndex == index) {
                break;
            }
            swap(arr, index, maxIndex);
            index = maxIndex;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i - 1);
        }
    }


}
