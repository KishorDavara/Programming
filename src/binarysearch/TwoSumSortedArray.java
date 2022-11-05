package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        int []numbers = {2,3,4};
        System.out.println(Arrays.toString(twoSum(numbers,6)));
    }

    public  static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i],i + 1);
        }
        int [] result = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int key = target-numbers[i];
            if(map.containsKey(key)) {
                result[0] = i + 1;
                result[1] = map.get(key);
                break;
            }
        }
        return result;
    }
}
