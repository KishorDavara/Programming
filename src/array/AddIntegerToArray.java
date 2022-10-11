package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/add-to-array-form-of-integer/description/
public class AddIntegerToArray {
    public static void main(String[] args) {
        int []num = {1,2,0,0};
        int k = 34;
        System.out.println(Arrays.toString(addToArrayForm(num,k).toArray()));
    }

    private static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int index = num.length - 1;
        while(index >= 0 || k != 0) {
            if(index >= 0) {
                k += num[index];
                index--;
            }
            result.addFirst(k % 10);
            k /= 10;
        }
        return result;
    }
}
