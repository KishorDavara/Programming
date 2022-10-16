package math;

// https://leetcode.com/problems/sum-of-number-and-its-reverse/description/
public class SumOfNumberAndReverse {
    public static void main(String[] args) {
        int num = 443;
        //int num = 63;
        //int num = 181;
        System.out.println(sumOfNumberAndReverse(num));
    }

    public static boolean sumOfNumberAndReverse(int num) {
        for(int i = 0; i <= num; i++) {
            int j = i;
            int reverse = 0;
            while(j > 0) {
                reverse = reverse * 10 + j % 10;
                j /= 10;
            }
            if(i + reverse == num) {
                System.out.println(i+" + "+ reverse + " = "+ num);
                return true;
            }
        }
        return false;
    }
}
