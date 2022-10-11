package array;


// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/
public class CellsWithOddValue {
    public static void main(String[] args) {
        int m = 2, n = 3;
        int [][]indices = {{0,1},{1,1}};
        System.out.println(oddCells(m,n,indices));
    }

    public static int oddCells(int m, int n, int[][] indices) {
        //return bruteForce(m,n,indices);
        return optimizedOne(m,n,indices);
    }

    // O(m*n + indices.length)
    private static int bruteForce(int m, int n, int[][] indices) {
        int matrix[][] = new int[m][n];
        for(int i = 0 ; i < indices.length; i++) {
            int row = indices[i][0];
            int column = indices[i][1];
            // row
            for(int j = 0; j < n; j++) {
                matrix[row][j] += 1;
            }

            // columns
            for(int k = 0; k < m; k++) {
                matrix[k][column] += 1;
            }
        }
        int count = 0;
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // O(m + n + indices.length)
    private static int optimizedOne(int m, int n, int [][] indices) {
        int row[] = new int[m];
        int column[] = new int[n];

        for(int [] ind : indices) {
            row[ind[0]]++;
            column[ind[1]]++;
        }

        int rowOdd = 0;
        int rowEven = 0;
        int columnOdd = 0;
        int columnEven = 0;

        for(int i = 0; i < m; i++) {
            if(row[i] % 2 != 0) {
                rowOdd++;
            } else {
                rowEven++;
            }
        }

        for(int i = 0; i < n; i++) {
            if(column[i] % 2 != 0) {
                columnOdd++;
            } else {
                columnEven++;
            }
        }

        // To get the number of odd numbers.
        // simple math formula is odd + even = odd
        // odd + odd = even, even + even = even
        // So if we multiply even numbers of column with
        // odd numbers of row we will get the numbers of odd
        // numbers and vice verca.


        // Think it every column are in a row
        // so any of them are odd give the result of odd.
        return rowOdd * columnEven + columnOdd  * rowEven;
    }

}
