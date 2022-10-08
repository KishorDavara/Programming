package binarysearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int []nums = {4,5,6,7,0,1,2};
        int target = 0;
        int index = searchElement(nums, target);
        if(index == -1) {
            System.out.println("Element "+ target+" doesn't exist in the array.");
        }
        System.out.println("Element "+ target+" found at index "+ index);
    }

    public static int searchElement(int nums[], int target) {
        int pivot = findPivotElementIndex(nums);

        if(pivot == -1) { // this means array is not rotated
            // perform normal binary search
            return binarySearch(nums,target,0, nums.length - 1);
        }
        if(nums[pivot] == target) {
            return pivot;
        }
        if(nums[0] <= target) {
            return binarySearch(nums,target,0, pivot - 1);
        }
        return binarySearch(nums,target,pivot + 1, nums.length - 1);
    }

    public static int findPivotElementIndex(int nums[]) {
        int start = 0;
        int end = nums.length;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // case 1 : element at mid index is greater than element at mid + 1 index
            if(mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // case 2: element at mid index is less than the element at mid - 1 index
            if(mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            // case 3: element at start index is greater than element at mid index
            if(nums[start] >= nums[mid]) {
                end = mid - 1;
            }
            // case 4: element at start index is less than element at mid index
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int array[], int target, int start, int end) {
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
