package array;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/description/
// Asked in: Amazon, Facebook, Google, Microsoft
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        //int [] nums = {-1,1,0,-3,3};
        int [] nums = {2,3,4,5};
        System.out.println(Arrays.toString(productOfArray(nums, nums.length)));
    }

    //Time Complexity: O(n)
    // logic is to run the 2 loop: one is for calculating the product of left side number and
    // 2 is for adding the right side product into left side product
    public static int[] productOfArray(int nums[], int n) {
        int [] product = new int[n];
        product[0] = 1;
        for(int i = 1; i < n; i++) { // left side product
            product[i] = product[i-1] * nums[i-1];
        }

        int right = 1;
        for(int i = n - 1; i >= 0; i--) { // merging it with right side product for final answer
            product[i] = right * product[i];
            right = right * nums[i];
        }
        return product;
    }
}
