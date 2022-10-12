package array;

import java.util.Arrays;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
// Asked in Microsoft
public class NUniqueIntegersSumUptoZero {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }

    public static int[] sumZero(int n) {
        int array[] = new int[n];
        int start = 0;
        int end = n - 1;
        while(start < end) {
            array[start] = start + 1;
            array[end] = -1 * array[start];
            start++;
            end--;
        }
        return array;
    }
}
