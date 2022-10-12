package array;

//https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
public class MatrixRotation {
    public static void main(String[] args) {
        int [][]mat = {{0,0,0},{0,1,0},{1,1,1}};
        int [][]target = {{1,1,1},{0,1,0},{0,0,0}};
        System.out.println(findRotation(mat,target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }

                if(target[i][j] == 0) {
                    zeroCount--;
                } else {
                    oneCount--;
                }
            }
        }
        if(zeroCount != 0 || oneCount != 0) {
            return false;
        }
        int rotationCount = 1;

        while(rotationCount <= 4 ) {
            rotate(mat,n);
            if(isEqual(mat,target,n)) {
                return true;
            }
            rotationCount++;
        }
        return false;
    }

    private static void rotate(int[][] matrix, int n) {
        // reverse raw order
        for(int i = 0 ; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = temp;
        }

        // transpose the the matrix
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static boolean isEqual(int[][] matrix, int[][] target, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
