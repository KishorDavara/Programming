package binarysearch;

public class OrderArgonsticsBinarySearch {
    public static void main(String[] args) {
        int array[] = {2,6,9,12,35,63,89,96};
        search(array,63);
        array = new int[]{98,85,63,48,32,28,19,8,5,1};
        search(array,32);
    }

    public static void search(int array[],int target) {
        if(array.length == 0 || array == null) {
            throw new IllegalArgumentException("You're trying to search in the empty array");
        }
        int start = 0;
        int end = array.length - 1;
        int result = -1;
        boolean isAscendingOrder = array[0] < array[end] ? true : false;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(array[mid] == target) {
                result=mid;
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
        if(result > -1) {
            System.out.println("Number "+ target+" is found at index "+result);
        } else {
            System.out.println("Number "+ target+" doesn't exists in the array.");
        }
    }
}
