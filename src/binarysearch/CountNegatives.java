package binarysearch;

public class CountNegatives {
    public static void main(String[] args) {
        int [][]grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
        System.out.println(countNegatives_optimized(grid));
    }

    //Time Complexity: O(m*n)
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    //Time Complexity: O(n + m)
    public static int countNegatives_optimized(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        for(int i = 0; i < row; i++) {
            if(grid[i][0] < 0) {
                count += column;
            } else if(grid[i][column-1] > 0) {
                continue;
            } else {
                count += binarySearch(grid[i]);
            }
        }
        return count;
    }

    public static int binarySearch(int [] grid) {
        int start = 0, end = grid.length - 1;
        while(start <= end) {
            int mid = start + (end-start) / 2;
            if(grid[mid] < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return grid.length - start;
    }
}
