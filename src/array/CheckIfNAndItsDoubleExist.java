package array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        int []arr = {10,2,5,3};
        //int []arr = {3,1,7,11};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int n : arr) {
            if(set.contains(n*2) || (n%2 == 0 && set.contains(n/2))) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }
}
