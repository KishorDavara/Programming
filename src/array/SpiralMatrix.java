package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/description/
//Asked in: Google, Microsoft
public class SpiralMatrix {
    public static void main(String[] args) {
        int [][]matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
            };
        System.out.println(spiralOrder(matrix).toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // left and right indicates column
        int left = 0;
        int right = matrix[0].length - 1;
        // top and bottom indicates row
        int top = 0;
        int bottom = matrix.length - 1;
        int direction = 0;
        while(left <= right && top <= bottom) {
         if(direction == 0) { //left to right
             for(int i = left; i <= right; i++) {
                 result.add(matrix[top][i]);
             }
             top++;
         } else if(direction == 1) { //top to bottom
             for(int i = top; i <= bottom; i++) {
                 result.add(matrix[i][right]);
             }
             right--;
         } else if(direction == 2) { // right to left
             for(int i = right; i >= left; i--) {
                 result.add(matrix[bottom][i]);
             }
             bottom--;
         } else { // bottom to top
             for(int i = bottom; i >= top; i--) {
                 result.add(matrix[i][left]);
             }
             left++;
         }
         direction = (direction+1) % 4;
        }
        return result;
    }
}
