public class Solution {
    public boolean exist(char[][] board, String word) {//20 ms
        if(board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        ArrayList<Point> entrance = new ArrayList<Point>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    entrance.add(new Point(i,j)); 
                }
            }
        }
        for(int i = 0; i < entrance.size(); i++) {
            Point start = entrance.get(i);
            if(existHelper(board, word, visited, start, 1)) {
                return true;
            }
        }
        return false;
    }
    public boolean existHelper(char[][] board, String word, boolean[][] visited, Point start, int pos) {
        int[] directionX = {-1,1,0,0};
        int[] directionY = {0,0,-1,1};
        if(pos == word.length()) {
            return true;
        }
        visited[start.x][start.y] = true;
        if(start.x > 0 && !visited[start.x+directionX[0]][start.y+directionY[0]]) {//verticle up
            Point temp = new Point(start.x+directionX[0], start.y+directionY[0]);
            if(word.charAt(pos) == board[temp.x][temp.y]) {
                if(existHelper(board, word, visited, temp, pos+1)) {
                    return true;
                }
            }
        }
        if(start.x < board.length-1 && !visited[start.x+directionX[1]][start.y+directionY[1]]) {//verticle down
            Point temp = new Point(start.x+directionX[1], start.y+directionY[1]);
            if(word.charAt(pos) == board[temp.x][temp.y]) {
                if(existHelper(board, word, visited, temp, pos+1)) {
                    return true;
                }
            }
        }
        if(start.y > 0 && !visited[start.x+directionX[2]][start.y+directionY[2]]) {//horizontally left
            Point temp = new Point(start.x+directionX[2], start.y+directionY[2]);
            if(word.charAt(pos) == board[temp.x][temp.y]) {
                if(existHelper(board, word, visited, temp, pos+1)) {
                    return true;
                }
            }
        }
        if(start.y < board[0].length-1 && !visited[start.x+directionX[3]][start.y+directionY[3]]) {//horizontally right
            Point temp = new Point(start.x+directionX[3], start.y+directionY[3]);
            if(word.charAt(pos) == board[temp.x][temp.y]) {
                if(existHelper(board, word, visited, temp, pos+1)) {
                    return true;
                }
            }
        }
        visited[start.x][start.y] = false;
        return false;
    }
    public boolean exist2(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if(word.length() == 0) {
            return true;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(find(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board, String word, int i, int j, int pos) {
        if(pos == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }
        board[i][j] = '#';
        boolean ans = find(board, word, i+1, j, pos+1) || find(board, word, i-1, j, pos+1) || 
                      find(board, word, i, j+1, pos+1) || find(board, word, i, j-1, pos+1);
        board[i][j] = word.charAt(pos);
        return ans;
    }
}