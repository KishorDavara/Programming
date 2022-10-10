package binarysearch;

import java.util.Arrays;

public class SearchInMatrix {
    public static void main(String[] args) {
        int [][] matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        System.out.println(Arrays.toString(searchInMatrix(matrix,34)));
    }

    public static int[] searchInMatrix(int [][] matrix , int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column >= 0) {
            if(matrix[row][column] == target) {
                return new int[]{row,column};
            } else if(matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}
