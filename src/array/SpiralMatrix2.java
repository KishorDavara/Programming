package array;

import java.util.Arrays;

//https://leetcode.com/problems/spiral-matrix-ii/description/
//Asked in: Amazon
public class SpiralMatrix2 {
    public static void main(String[] args) {
        int n = 4;
        int [][]matrix = generateMatrix(n);
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int direction = 0;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int k = 1;
        while(left <= right && top <= bottom) {
            if(direction == 0) {
                for(int i = left; i <= right; i++) {
                    matrix[top][i] = k++;
                }
                top++;
            } else if(direction == 1) {
                for(int i = top; i <= bottom; i++) {
                    matrix[i][right] = k++;
                }
                right--;
            } else if(direction == 2 ) {
                for(int i = right; i >= left; i--) {
                    matrix[bottom][i] = k++;
                }
                bottom--;
            } else {
                for(int i = bottom; i >= top; i--) {
                    matrix[i][left] = k++;
                }
                left++;
            }
            direction = (direction+1) % 4;
        }
        return matrix;
    }
}
