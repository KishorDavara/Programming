package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {2, 6, 9, 12, 35, 63, 89, 96};
        int target = 63;
        int result = search(array, target);
        if (result > -1) {
            System.out.println("Number " + target + " is found at index " + result);
        } else {
            System.out.println("Number " + target + " doesn't exists in the array.");
        }
    }

    public static int search(int array[], int target) {
        if (array.length == 0 || array == null) {
            throw new IllegalArgumentException("You're trying to search in the empty array");
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
