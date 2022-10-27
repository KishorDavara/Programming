package binarysearch;

public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins_Iterative(5));
        System.out.println(arrangeCoins_Iterative(8));
        System.out.println(arrangeCoins_Iterative(1));
        System.out.println(arrangeCoins_binarySearch(5));
        System.out.println(arrangeCoins_binarySearch(8));
        System.out.println(arrangeCoins_binarySearch(1));
    }

    //Time Complexity: O(sqrt(N))
    public static int arrangeCoins_Iterative(int n) {
        int row = 1;
        int count = 0;
        while(n > 0) {
            if(n >= row) {
                count++;
            }
            n = n - row;
            row++;
        }
        return count;
    }

    //credit: https://leetcode.com/problems/arranging-coins/solutions/551419/arranging-coins/
    private static int arrangeCoins_binarySearch(int n) {
        long left = 0, right = n, mid , k;
        while(left <= right) {
            mid = left + (right - left) / 2;
            k = mid * (mid + 1) / 2;
            if(k == n) {
                return (int)mid;
            }
            if(n < k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }
}
