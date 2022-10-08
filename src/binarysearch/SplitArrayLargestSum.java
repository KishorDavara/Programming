package binarysearch;

//https://leetcode.com/problems/split-array-largest-sum/description/
// Asked in Google
// Explanation: https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=12616s
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        //int k = 1;
        int k = 2;
        //int k = 3;
        //int k = 4;
        //int k = 5;
        System.out.println("Minimized largest sum of the split is: " + splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        // answer will lie between start and end
        for (int n : nums) {
            start = Math.max(start, n);
            end += n;
        }
        // binary search
        while (start < end) {
            int mid = start + (end - start) / 2; // this is our possible answer
            int sum = 0;
            int partition = 1;
            for (int n : nums) {
                if (sum + n > mid) { // this means current partition sum exceeds mid so we need to move this number number into new partition
                    sum = n;
                    partition++;
                } else { // keeps on adding into existing partition
                    sum += n;
                }
            }
            if (partition > k) { // this means possible answer is very less and we need to increase the possible answer
                start = mid + 1;
            } else { // this means possible answer is large and we need to decrease the possible answer
                end = mid;
            }
        }
        return start; // we can also return "end" as at the end value of start==mid==end
    }
}
