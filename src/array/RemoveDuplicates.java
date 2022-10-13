package array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Asked in: Facebook, Google, Microsoft
public class RemoveDuplicates {
    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 1, k = 1;
//        while(i < nums.length) {
//            while(i < nums.length && nums[i] == nums[i-1]) {
//                i++;
//            }
//            if(i < nums.length) {
//                nums[k++] = nums[i++];
//            }
//
//        }
        for( i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
