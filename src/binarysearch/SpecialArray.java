package binarysearch;

public class SpecialArray {
    public static void main(String[] args) {
       //int[] nums = {3,5};
       //int[] nums = {0,0};
       int[] nums = {0,4,3,0,4};
       System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        int start = 0, end = nums.length;
        while(start <= end) {
            int mid = start + (end-start)/2;
            int count = 0;
            for(int n : nums) {
                if(n >= mid) {
                    count++;
                }
            }
            if(count == mid) {
                return mid;
            } else if(count < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
