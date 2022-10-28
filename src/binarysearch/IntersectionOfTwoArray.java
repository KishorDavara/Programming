package binarysearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/intersection-of-two-arrays/description/
public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        if (nums1.length < nums2.length) {
            for (int n : nums1) {
                if (binarySearch(nums2, n)) {
                    set.add(n);
                }
            }
        } else {
            for (int n : nums2) {
                if (binarySearch(nums1, n)) {
                    set.add(n);
                }
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();*/
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums1) {
            set.add(n);
        }
        for(int n : nums2) {
            if(set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}

