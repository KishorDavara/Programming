package array;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-subarray/description/
// Asked In: Facebook, Microsoft
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int [] nums = {1};
        //int [] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
        System.out.println(Arrays.toString(maxSubArray_index(nums)));
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

    public static int[] maxSubArray_index(int [] nums) {
        int maxSum = nums[0], sum = nums[0], endIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if(sum > maxSum) {
                maxSum = sum;
                endIndex = i;
            }
        }
        int [] result = new int[2];
        result[1] = endIndex;
        while(maxSum > 0) {
            maxSum -= nums[endIndex];
            endIndex--;
        }
        result[0] = endIndex + 1; // startIndex
        return result;
    }

}
