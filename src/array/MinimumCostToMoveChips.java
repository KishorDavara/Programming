package array;

// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
public class MinimumCostToMoveChips {
    public static void main(String[] args) {
        int []position = {2,2,2,3,3};
        System.out.println(minCostToMoveChips(position));
    }

    public static int minCostToMoveChips(int[] position) {
        int evenPositionCount = 0;
        int oddPositionCount = 0;
        for(int p : position) {
            if(p % 2 == 0) {
                evenPositionCount++;
            } else {
                oddPositionCount++;
            }
        }
        return Math.min(evenPositionCount,oddPositionCount);
    }
}
