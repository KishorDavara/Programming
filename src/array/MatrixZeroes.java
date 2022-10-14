package array;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/set-matrix-zeroes/description/
// Asked in: Amazon
public class MatrixZeroes {
    public static void main(String[] args) {
       int [][]matrix = {{0,1,2,0},
               {3,4,5,2},
               {1,3,1,5}};
       //setZeroes(matrix);
        setZeroes_spaceEfficient(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Time Complexity : O(M×N)
    //Space Complexity : O(M + N)
    public static void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(row.contains(i) || column.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Time Complexity : O(M×N)
    //Space Complexity : O(1)
    public static void setZeroes_spaceEfficient(int[][] matrix) {
        boolean firstColumnZero = false;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                firstColumnZero = true;
            }
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
            for(int i = 1; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(firstColumnZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
