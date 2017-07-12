public class Solution {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] OPT = new int[m][n];
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            OPT[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            OPT[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    OPT[i][j] = 0;
                } else {
                    OPT[i][j] = OPT[i-1][j]+OPT[i][j-1];
                }
            }
        }
        return OPT[m-1][n-1];
    }
}