package dynamicprogramming.cansum;

//Write a program to identify that can we generate targetSum using the elements of Array
public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3})); //true
        System.out.println(canSum(7, new int[]{5, 3, 4, 7})); //true
        System.out.println(canSum(7, new int[]{2, 4})); //false
        System.out.println(canSum(8, new int[]{2, 3, 5})); //true
        System.out.println(canSum(3000, new int[]{7, 14})); //false
    }

    private static boolean canSum(int targetSum, int[] numbers) {
        return canSum_Recursion(targetSum, numbers);
    }

    private static boolean canSum_Recursion(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum_Recursion(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }
}
