package binarysearch;

// Find the floor of the number in sorted array
// Floor of number: greatest number smaller than or equal to target
public class FloorOfNumber {
    public static void main(String[] args) {
        int array[] = {2, 6, 9, 12, 35, 63, 89, 96};
        int target = 65;
        //int target = 1;
        int result = floor(array, target);
        if (result > -1) {
            System.out.println("Floor of the number " + target + " is present at index: " + result);
        } else {
            System.out.println("Floor of the number " + target + " doesn't exists in the array");
        }
    }

    // return the index of greatest number <= target
    public static int floor(int array[], int target) {
        if (array.length == 0 || array == null) {
            throw new IllegalArgumentException("You're trying to search in the empty array");
        }
        int start = 0;
        int end = array.length - 1;
        // but what if the target number is the smaller than smallest number in the array
//        if (target < array[start]) {
//            return -1;
//        }
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
        return end;
    }
}
