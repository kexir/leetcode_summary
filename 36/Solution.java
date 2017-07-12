public class Solution {
    public boolean isValidSudoku(char[][] board) {//37ms
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!set.add(board[i][j]+" in rows "+i) ||
                   !set.add(board[i][j]+" in cols "+j) ||
                   !set.add(board[i][j]+" in blocks ("+ i/3 +"-"+j/3+")")){
                    return false;
                }
            }
        }
        return true;
    }
    // 32 ms
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j]-'0'-1;
                int index = 3*(i/3) + j/3;
                if(rows[i][num] || cols[j][num] || block[index][num]){
                    return false;
                }
                rows[i][num] = cols[j][num] = block[index][num] =true;
            }
        }
        return true;
    }
}