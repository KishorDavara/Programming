package array;

//https://leetcode.com/problems/jump-game/description/
//Asked in : Microsoft
public class MaxJump {
    public static void main(String[] args) {
        int []nums = {2,3,1,1,4};
        //int []nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            // If the current index 'i' is less than current maximum jump 'curr'. It means there is no way to jump to current index. so we should return false.
            if (i > curr) {
                return false;
            }
            curr = Math.max(curr, i + nums[i]);
        }
        return true;
    }
}
