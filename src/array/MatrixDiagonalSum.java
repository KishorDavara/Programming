package array;

// https://leetcode.com/problems/matrix-diagonal-sum/description/
public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(diagonalSum(matrix));
        matrix = new int[][]{{1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}};
        System.out.println(diagonalSum(matrix));
    }

    private static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[n-i-1][i];
        }

        if(n % 2 != 0) {
            sum -= mat[n/2][n/2];
        }
        return sum;
    }
}
