package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public static void main(String[] args) {
        int []nums = {2,11,7,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)) {
                return new int[] {map.get(key),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
