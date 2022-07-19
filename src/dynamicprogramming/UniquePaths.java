package dynamicprogramming;

// https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 1)); //1
        System.out.println(uniquePaths(2, 3)); //3
        System.out.println(uniquePaths(3, 2)); //3
        System.out.println(uniquePaths(3, 3)); //6
        System.out.println(uniquePaths(18, 18)); //233606220
    }

    private static long uniquePaths(int m, int n) {
        long [][] memo = new long[m+1][n+1];
        return uniquePaths_DP(m,n,memo);
        //return uniquePaths_Recursion(m, n);
    }

    private static long uniquePaths_Recursion(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 0 || n == 0) {
            return 0;
        }
        return uniquePaths_Recursion(m - 1, n) + uniquePaths_Recursion(m, n - 1);
    } // Time Complexity: O(2^m+n) Space Complexity: O(m+n)

    private static long uniquePaths_DP(int m, int n, long[][]memo) {
        if(memo[m][n] != 0) {
            return memo[m][n];
        }
        if(m == 1 && n == 1) {
            return 1;
        }
        if(m == 0 || n == 0) {
            return 0;
        }
        memo[m][n] = uniquePaths_DP(m - 1, n, memo) + uniquePaths_DP(m,n - 1, memo);
        return memo[m][n];
    } // Time Complexity: O(m * n) Space Complexity: O(m+n)

}
