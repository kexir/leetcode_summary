public class NumMatrix {
    
	private int[][] tree;
    private int[][] nums;
    
    public NumMatrix(int[][] matrix) {
        tree = new int[matrix.length+1][matrix[0].length+1];
        nums = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                update(i,j,matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val-nums[row+1][col+1];
        for(int i = row+1; i < tree.length; i += (i&-i)) {
            for(int j = col+1; j < tree[0].length; j += (j&-j)) {
                tree[i][j] += diff;
            }
        }
        nums[row+1][col+1] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2+1,col2+1)-getSum(row2+1,col1)-getSum(row1,col2+1)+getSum(row1, col1);
    }
    
    private int getSum(int row, int col) {
        int ans = 0;
        for(int i = row; i > 0; i -= (i&-i)) {
            for(int j = col; j > 0; j -= (j&-j)) {
                ans += tree[i][j];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        /*int[][] nums = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(nums);
        int param_1 = obj.sumRegion(2,1,4,3);
        System.out.println(param_1);
        obj.update(3,2,2);
        int param_2 = obj.sumRegion(2,1,4,3);*/
        System.out.println(Character.toUpperCase('4'));
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */