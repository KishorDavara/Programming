package recursion;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("bike")); // false
    }

    private static boolean isPalindrome(String str) {
        if(str.length() == 0 || str.length() == 1) {
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1,str.length() - 1));
        }
        //in case of non-palindrome string
        return false;
    }
}
