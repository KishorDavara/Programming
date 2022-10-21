package binarysearch;

//https://leetcode.com/problems/sqrtx/description/
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if(x < 2)
            return x;
        int left = 0;
        int right = x / 2;
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
