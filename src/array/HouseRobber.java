package array;

//https://leetcode.com/problems/house-robber/description/
//Asked in: Google
public class HouseRobber {
    public static void main(String[] args) {
        int []nums = {2,7,9,3,1};
        //int [] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }

    //Approach Credit: https://leetcode.com/problems/house-robber/solutions/156523/from-good-to-great-how-to-approach-most-of-dp-problems/
    public static int rob(int[] nums) {
//        int n = nums.length;
//        int []dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            dp[i+1] = Math.max(dp[i],dp[i-1] + nums[i]);
//        }
//
//        return dp[n];

        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
