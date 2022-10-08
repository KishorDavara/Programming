package binarysearch;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// https://leetcode.com/problems/find-peak-element/
public class PickIndexInMountainArray {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,4,3,2,1};
        System.out.println("Pick index is: "+peakIndexInMountainArray(array));
    }

    private static int peakIndexInMountainArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] > array[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; // or return end as both become equal at the end and both are pointing to the pick index
    }
}
