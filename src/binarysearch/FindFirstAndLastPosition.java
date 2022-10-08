package binarysearch;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Asked in Facebook
public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        //int result[]=searchRange_bruteForce(nums,target);
        int result[] = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    //Brute Force Solution: Time Complexity O(n)
    public static int[] searchRange_bruteForce(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        boolean foundFirstIndex = false, foundLastIndex = false;
        while (start <= end) {
            if (!foundFirstIndex) {
                if (nums[start] == target) {
                    result[0] = start;
                    foundFirstIndex = true;
                } else {
                    start++;
                }
            }
            if (!foundLastIndex) {
                if (nums[end] == target) {
                    result[1] = end;
                    foundLastIndex = true;
                } else {
                    end--;
                }
            }
            if (foundFirstIndex && foundLastIndex) {
                break;
            }
        }
        return result;
    }

    // Binary Search Solution: Time Complexity O(logN)
    public static int[] searchRange(int[] nums, int target) {
        int result[] = {-1, -1};
        result[0] = findIndex(nums, target, true);
        if (result[0] != -1) {
            result[1] = findIndex(nums, target, false);
        }
        return result;
    }

    public static int findIndex(int[] nums, int target, boolean findFirstIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if (findFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
