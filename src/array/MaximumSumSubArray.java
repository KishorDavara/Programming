package array;

// https://leetcode.com/problems/maximum-subarray/description/
// Asked In: Facebook, Microsoft
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0], sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
