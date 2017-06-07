class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                   markBFS(grid, i, j); 
                   count ++;
                }
            }
        }
        return count;
    }
    public void markBFS(char[][] grid, int row, int col) {
        int[] directionX = {0,0,-1,1};
        int[] directionY = {-1,1,0,0};
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(row,col));
        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                Point new_point = new Point(temp.x+directionX[i], temp.y+directionY[i]);
                if(!inBound(grid, new_point)) {
                    continue;
                }
                if(grid[new_point.x][new_point.y] == '1') {
                    queue.offer(new_point);
                    grid[new_point.x][new_point.y] = '0';
                }
            }
        }
    }
    public boolean inBound(char[][] grid, Point point) {
        int row = grid.length;
        int col = grid[0].length;
        if (point.x < 0 || point.x >= row){
            return false; 
        }
        if (point.y < 0 || point.y >= col){
            return false; 
        }
        return true;
    }
}