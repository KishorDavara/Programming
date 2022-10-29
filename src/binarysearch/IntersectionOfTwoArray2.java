package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
//Asked in: Amazon
public class IntersectionOfTwoArray2 {
    public static void main(String[] args) {
        int []nums1 = {4,9,5};
        int []nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums1) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int n : nums2) {
            if(map.containsKey(n)) {
                list.add(n);
                int count = map.get(n)-1;
                if(count == 0) {
                    map.remove(n);
                } else {
                    map.put(n,count);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
