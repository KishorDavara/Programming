package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 4, 6, 9, 12, 45, 61}, 0, 7, 6)); //true
        System.out.println(binarySearch(new int[]{1, 2, 4, 6, 9, 12, 45, 61}, 0, 7, 16)); //false
    }

    private static boolean binarySearch(int array[], int left, int right, int x) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == x) {
            return true;
        } else if (x < array[mid]) {
            return binarySearch(array, left, right - 1, x);
        } else {
            return binarySearch(array, left + 1, right, x);
        }
    }
}
