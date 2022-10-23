package binarysearch;

//https://leetcode.com/problems/valid-perfect-square/description/
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare(int num) {
        if(num <= 1) {
            return true;
        }
        int lastDigit = num % 10;
        if(lastDigit == 2 || lastDigit == 3 || lastDigit == 7 || lastDigit == 8)
            return false;
        int start = 1;
        int end = num / 2;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            long y = (long)mid * mid;
            if(y == num) {
                return true;
            } else if(y < num) {
                start = mid + 1;
            }  else {
                end = mid - 1;
            }
        }
        return false;
    }
}
