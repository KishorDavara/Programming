package binarysearch;

//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//Asked in Amazon
public class FindElementPositionInfiniteSortedArray {
    public static void main(String[] args) {
        int array[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        int elementPosition = findElementPosition(array, target);
        if (elementPosition == -1) {
            System.out.println("Element " + target + " not found");
        } else {
            System.out.println("Element " + target + " is present at index " + elementPosition);
        }
    }

    private static int findElementPosition(int[] array, int target) {
        int start = 0;
        int end = 1;
        while (target > array[end]) {
            int newStart = end + 1;
            // double the size of box
            // end = previous end + sizeOfBox * 2
            /* this may sometime result in ArrayIndexOutOfBoundsException exception, but it's okay because we're testing using finite array
            as it's not possible to test it by creating infinite array*/
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return search(array, target, start, end);
    }

    private static int search(int array[], int target, int start, int end) {
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
