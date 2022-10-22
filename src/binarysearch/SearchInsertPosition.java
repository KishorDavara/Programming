package binarysearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        System.out.println(search(nums,5));
        System.out.println(search(nums,2));
        System.out.println(search(nums,7));
    }

    public static int search(int array[], int target) {
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
        return start;
    }
}
