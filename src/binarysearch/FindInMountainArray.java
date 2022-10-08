package binarysearch;

public class FindInMountainArray {
    public static void main(String[] args) {
        int []array = {1,2,3,4,5,3,1};
        int target = 3;
        int pickIndex = peakIndexInMountainArray(array);
        int targetIndex = orderArgonsticsBinarysearch(array,target,0,pickIndex);
        if(targetIndex == -1) {
            targetIndex = orderArgonsticsBinarysearch(array,target,pickIndex + 1, array.length - 1);
        }
        if(targetIndex == -1) {
            System.out.println("Element "+ target +" doesn't exist in the mountain array");
        } else {
            System.out.println("Element "+ target+" is present at index: "+ targetIndex);
        }

    }

    private static int peakIndexInMountainArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] > array[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; // or return end as both become equal at the end and both are pointing to the pick index
    }

    public static int orderArgonsticsBinarysearch(int array[],int target,int start,int end) {
        boolean isAscendingOrder = array[start] < array[end] ? true : false;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(array[mid] == target) {
                return mid;
            }
            if(isAscendingOrder) {
                if(array[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(array[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
