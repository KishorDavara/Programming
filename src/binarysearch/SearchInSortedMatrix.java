package binarysearch;


// https://leetcode.com/problems/search-a-2d-matrix/description/
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                    {1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 60}
                  };
        int target = 16;
        System.out.println(searchInMatrix(matrix,target));
    }

    private static boolean searchInMatrix(int [][] matrix, int target) {
      if(matrix.length == 0) {
          throw new IllegalArgumentException("Matrix is empty.");
      }
      int col = matrix[0].length - 1;
        for(int row = 0; row < matrix.length; row++) {
          if(matrix[row][0] == target || matrix[row][col] == target) {
              return true;
          } else if(matrix[row][0] < target && matrix[row][col] > target) {
              return binarySearch(matrix,row,target);
          }
      }
        return false;
    }

    private static boolean binarySearch(int [][] matrix, int row, int target) {
        int start = 1;
        int end = matrix[row].length - 2;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
