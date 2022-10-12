package array;

//https://leetcode.com/problems/maximum-population-year/description/
public class MaximumPopulationYear {
    public static void main(String[] args) {
        int [][]logs = {
                {1950,1961},
                {1960,1971},
                {1970,1981}};
        System.out.println(maximumPopulation(logs));
    }

    public static int maximumPopulation(int[][] logs) {
        int year[] = new int[101]; // 1950 -> 2050
        for(int [] log : logs) {
            year[log[0] - 1950]++;
            year[log[1] - 1950]--;
        }

        int maxPopulation = year[0], maxPopulationYear = 1950;

        for(int i = 1; i < 101; i++) {
            year[i] += year[i-1];
            if(year[i] > maxPopulation) {
                maxPopulation = year[i];
                maxPopulationYear = i + 1950;
            }
        }
        return maxPopulationYear;
    }
}
