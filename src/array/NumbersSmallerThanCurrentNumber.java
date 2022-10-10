package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
public class NumbersSmallerThanCurrentNumber {
    public static void main(String[] args) {
        int []nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        //return bruteForceApproach(nums);
        //return optimizedSolution(nums);
        return bestSolution(nums);
    }

    //Time Complexity: O(n^2)
    private static int[] bruteForceApproach(int [] nums) {
        int ans[] = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(i != j && nums[j] < nums[i]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    //Time Complexity: O(nlogn)
    private static int[] optimizedSolution(int [] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] copy = nums.clone();
        Arrays.sort(copy);
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i],i);
        }
        for(int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }
        return copy;
    }

    //Time Complexity: O(m + n) where m value is 101
    private static int[] bestSolution(int [] nums) {
        int[] count = new int[101];
        for(int i = 0 ; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for(int i = 1; i < 101; i++) {
            count[i] += count[i-1];
        }
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? 0 :count[nums[i]-1];
        }
        return ans;
    }
}
