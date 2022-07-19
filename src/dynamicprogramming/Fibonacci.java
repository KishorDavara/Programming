package dynamicprogramming;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(NthFibonacciNumber(6)); //8
        System.out.println(NthFibonacciNumber(7)); //13
        System.out.println(NthFibonacciNumber(8)); //21
        System.out.println(NthFibonacciNumber(50)); //12586269025
        System.out.println(NthFibonacciNumber(150)); //6792540214324356296
    }

    public static long NthFibonacciNumber(int n) {
        //return NthFibonacciNumber_Recursion(n);

        long memo[] = new long[n + 1];
        return NthFibonacciNumber_DP(n, memo);
    }

    private static long NthFibonacciNumber_Recursion(int n) {
        if (n <= 2) {
            return 1;
        }

        return NthFibonacciNumber_Recursion(n - 1) + NthFibonacciNumber_Recursion(n - 2);
    } //Time Complexity: O(2^n) Space Complexity: O(n)

    private static long NthFibonacciNumber_DP(int n, long[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n <= 2) {
            return 1;
        }
        memo[n] = NthFibonacciNumber_DP(n - 1, memo) + NthFibonacciNumber_DP(n - 2, memo);
        return memo[n];
    } //Time Complexity: O(n) Space Complexity: O(n)
}


