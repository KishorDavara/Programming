package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
//Asked in: Amazon
public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers, 6)));
        System.out.println(Arrays.toString(twoSum_optimized(numbers,6)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (map.containsKey(key)) {
                result[0] = i + 1;
                result[1] = map.get(key);
                break;
            }
        }
        return result;
    }

    public static int[] twoSum_optimized(int[] nums, int target) {
        for (int left = 0; left < nums.length; left++) {
            int right = binarySearch(nums, left + 1, target - nums[left]);
            if (right != -1) {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }

    private static int binarySearch(int[] nums, int left, int target) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
