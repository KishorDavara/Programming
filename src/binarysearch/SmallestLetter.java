package binarysearch;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class SmallestLetter {
    public static void main(String[] args) {
        char letters[] = {'c', 'f', 'j'};
        //char target = 'a';
        char target = 'j';
        System.out.println("Smallest character in the array that is larger than target " + target + " is: " + nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length]; // need to take modulo here because if there is no greater element found than the target element then we need to return first element
    }
}
