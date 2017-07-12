// Spiral Matrix II
public class Solution2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0) {
            return matrix;
        }
        int curt = 1;
        int rowStart = 0, colStart = 0;
        int rowEnd = n, colEnd = n;
        while(curt <= n*n && rowStart < rowEnd && colStart < colEnd) {
            for(int i = colStart; curt <= n*n && i < colEnd; i++) {
                matrix[rowStart][i] = curt++;
            }
            rowStart++;
            for(int i = rowStart; curt <= n*n && i < rowEnd; i++) {
                matrix[i][colEnd-1] = curt++;
            }
            colEnd--;
            for(int j = colEnd-1; curt <= n*n && j >= colStart; j--) {
                matrix[rowEnd-1][j] = curt++;
            }
            rowEnd--;
            for(int j = rowEnd-1; curt <= n*n && j >= rowStart; j--) {
                matrix[j][colStart] = curt++;
            }
            colStart++;
        }
        return matrix;
    }
}