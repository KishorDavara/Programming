package binarysearch;

//https://leetcode.com/problems/kth-missing-positive-number/description/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int []arr = {2,3,4,7,11};
        System.out.println(findKthPositive_N(arr,5));
        arr = new int[]{1,2,3,4};
        System.out.println(findKthPositive_LogN(arr,2));
    }

    //Time Complexity: O(n)
    public static int findKthPositive_N(int[] arr, int k) {
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

    //Credit: https://leetcode.com/problems/kth-missing-positive-number/solutions/2621917/java-binary-search-approach-100-faster/
    //Time Complexity: O(logN)
    public static int findKthPositive_LogN(int[] arr, int k) {
        int n = arr.length;
        int missing = computeMissing(arr[n-1],n);
        //case ex; [1,2,3,4] k = 2 ans: 6
        if(missing == 0) {
            return arr[n-1] + k;
        }
        int start = 0; //4
        int end = n - 1; // 3
        while(start <= end) {
            int mid = start + (end - start) / 2; // 4
            missing = computeMissing(arr[mid],mid+1); //6
            if(missing >= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // case ex; [3,4,5] k = 2 ans : 2
        if(end == -1) {
            return k;
        }

        // case(missing number in between array) ex: [2,3,4,7,11], k = 5
        return arr[end] + k - computeMissing(arr[end],end+1);
    }

    private static int computeMissing(int to, int from) {
        return to - from;
    }
}
