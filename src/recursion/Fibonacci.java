package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(NthFibonacciNumber(6)); //8
        System.out.println(NthFibonacciNumber(11)); //89
        System.out.println(NthFibonacciNumber(120)); //89
    }

    private static long NthFibonacciNumber(int n) {
        if(n ==1 || n == 2) {
            return 1;
        }
        return NthFibonacciNumber(n - 1) + NthFibonacciNumber(n - 2);
    }
}
