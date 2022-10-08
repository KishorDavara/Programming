package binarysearch;

// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class CountRotation {
    public static void main(String[] args) {
        //int[] arr = { 2, 3, 6, 12 }; // 0
        //int[] arr = { 15, 2, 3, 6, 12 }; // 1
        //int[] arr = { 15, 18, 2, 3,6, 12 }; // 2
        int[] arr = {15, 18, 20, 2, 3, 6, 12}; //3
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int[] arr) {
        return findPivotIndex(arr) + 1;
    }

    private static int findPivotIndex(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] >= arr[mid]) { // this means pivot is in left side of the part
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
