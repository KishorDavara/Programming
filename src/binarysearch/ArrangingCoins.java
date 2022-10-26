package binarysearch;

public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins_Iterative(5));
        System.out.println(arrangeCoins_Iterative(8));
        System.out.println(arrangeCoins_Iterative(1));
    }

    //Time Complexity: O(sqrt(N))
    public static int arrangeCoins_Iterative(int n) {
        int row = 1;
        int count = 0;
        while(n > 0) {
            if(n >= row) {
                count++;
            }
            n = n - row;
            row++;
        }
        return count;
    }
}
