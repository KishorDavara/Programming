package array;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/description/
// Asked in : Amazon
public class SortColors {
    public static void main(String[] args) {
        int []nums = {2,0,2,1,1,0};
        //sortColors(nums);
        sortColors_OnePass(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int n : nums) {
            if(n == 0) {
                red++;
            } else if(n == 1) {
                white++;
            } else {
                blue++;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(red > 0) {
                nums[i] = 0;
                red--;
            } else if(white > 0) {
                nums[i] = 1;
                white--;
            } else {
                nums[i] = 2;
                blue--;
            }
        }
    }


    private static void sortColors_OnePass(int[] nums) {
        int zero = 0, second = nums.length - 1;
        // idea is to move all 0's to left and all 2's to right and keep 1's to middle
        for(int i = 0; i <= second; i++) {
            if(nums[i] == 0) {
                swap(nums,i,zero);
                zero++;
            }
            if(nums[i] == 2) {
                swap(nums,i,second);
                second--;
                i--; // Continue handle i after swap, since we don't know nums[second]
            }
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
