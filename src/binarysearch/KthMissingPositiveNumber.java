package binarysearch;

//https://leetcode.com/problems/kth-missing-positive-number/description/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int []arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr,5));
        arr = new int[]{1,2,3,4};
        System.out.println(findKthPositive(arr,2));
    }

    //Time Complexity: O(n)
    public static int findKthPositive(int[] arr, int k) {
        int i = 0;
        int n = 1;
        while(i < arr.length) {
            if(n != arr[i]) {
                k--;
                n++;
            } else  {
                i++;
                n++;
            }
            if(k == 0) {
                return n - 1;
            }
        }
        return n + k - 1;
    }
}
