package recursion;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("the simple engineer")); //reenigne elplis eht
    }

    private static String reverse(String str) {
        if(str.equals(""))
            return "";
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
