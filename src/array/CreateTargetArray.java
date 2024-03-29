package array;

import java.util.Arrays;

//https://leetcode.com/problems/create-target-array-in-the-given-order/description/
public class CreateTargetArray {
    public static void main(String[] args) {
        //int [] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
        int [] nums = {1,2,3,4,0}, index = {0,1,2,3,0};
        System.out.println(Arrays.toString(createTargetArray(nums,index)));
    }

    private static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            int indVal = index[i];
            if(indVal < i) {
                int j = i;
                while(j > indVal) {
                    target[j] = target[j-1];
                    target[j-1] = nums[i];
                    j--;
                }
            } else {
                target[i] = nums[i];
            }
        }
        return target;
    }
}
