package array;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/description/
public class PlusOne {
    public static void main(String[] args) {
        //int [] nums = {1,4,5};
        //int [] nums = {9,8,9};
        int [] nums = {9,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--)
        {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1; // we only need to set the first element to 1 as by default all the elements of array initialize with 0
        return newNumber;
    }
}
