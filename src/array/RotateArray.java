package array;


import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/description/
//Asked in: Amazon, Facebook, Microsoft
public class RotateArray {
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int []ans = new int[n];
        for(int i = 0; i < n; i++) {
            int index = (i + k) % n;
            ans[index] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }
}
