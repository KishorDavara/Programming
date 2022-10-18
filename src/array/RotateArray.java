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
        //rotateUsingExtraSpace(nums,k);
        rotateInPlace(nums,k);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    private static void rotateUsingExtraSpace(int[] nums, int k) {
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

    private static void rotateInPlace(int [] nums, int k) {
        // original array: [1,2,3,4,5,6,7]
        k = k % nums.length;

        // After below call: [7,6,5,4,3,2,1]
        reverse(nums,0, nums.length - 1); // reverse entire array

        // After below call: [5,6,7,4,3,2,1]
        reverse(nums,0, k - 1); // reverse first k elements

        // After below call: [5,6,7,1,2,3,4]
        reverse(nums, k, nums.length - 1 ); // reverse remaining elements(k+1 to last elements)
    }

    private static void reverse(int [] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
