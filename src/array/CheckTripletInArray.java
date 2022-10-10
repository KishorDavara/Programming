package array;

import java.util.HashSet;
import java.util.Set;

// https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
// Asked in Amazon
public class CheckTripletInArray {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5 };
        System.out.println(isTripletPresent(arr, arr.length));
    }
    private static boolean isTripletPresent(int arr[], int n) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n; i++) {
            arr[i] = arr[i] * arr[i];
            set.add(arr[i]);
        }

        for(int i = 0 ; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(set.contains(arr[i]+arr[j])){
                    return true;
                }
            }
        }
        return false;
    }
}
