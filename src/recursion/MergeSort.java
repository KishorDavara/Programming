package recursion;

public class MergeSort {
    public static void main(String[] args) {
        int array[] = new int[]{4, 1, 3, 2, 0, -1, 7, 10, 9, 20};
        mergeSort(array, 0, array.length - 1);
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int array[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (i = start; i <= end; i++) {
            array[i] = temp[i - start];
        }
    }
}
