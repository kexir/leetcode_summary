import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Point;

public class Solution {
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = {{2,3}};
        // System.out.println(spiralOrder(matrix));
        StringBuilder sb = new StringBuilder();
        int j = 1;
        sb.append(j+1);
        System.out.println(sb.toString());
    }
    public static List<Integer> spiralOrder(int[][] matrix) {//4ms
        List<Integer> ans = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) {
            return ans;
        }
        int rowStart = 0;
        int rowEnd = matrix.length;
        int colStart = 0;
        int colEnd = matrix[0].length;
        while(rowStart < rowEnd && colStart < colEnd) {
            for(int i = colStart; i < colEnd; i++) {
                System.out.println(matrix[rowStart][i]);
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;
            System.out.println(rowStart + " " + rowEnd);
            for(int i = rowStart; i < rowEnd; i++) {
                System.out.println(matrix[i][colEnd-1]);
                ans.add(matrix[i][colEnd-1]);
            }
            colEnd--;
            if(rowStart >= rowEnd || colStart >= colEnd) {//only one line
                continue;
            }
            for(int j = colEnd-1; j >= colStart; j--) {
                System.out.println(matrix[rowEnd-1][j]);
                ans.add(matrix[rowEnd-1][j]);
            }
            rowEnd--;
            for(int j = rowEnd-1; j >= rowStart; j--) {
                System.out.println(matrix[j][colStart]);
                ans.add(matrix[j][colStart]);
            }
            colStart++;
        }
        return ans;
    }
    public static List<Integer> spiralOrder2(int[][] matrix) {//java.lang.StackOverflowError?
        List<Integer> ans = new ArrayList<Integer>();
        HashSet<Point> set = new HashSet<Point>();
        Point point = new Point(0,0);
        spiralOrderHelper(matrix, set, point, ans, 0);
        return ans;
    }
    public static boolean spiralOrderHelper(int[][] matrix, HashSet<Point> set, Point point, List<Integer> ans, int direction) {
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        if(set.contains(point) || point.x >= matrix[0].length || point.x < 0 || point.y >= matrix.length || point.y < 0) {
            return false;
        }
        ans.add(matrix[point.x][point.y]);
        set.add(point);
        
        Point new_point = new Point(point.x+directionX[direction],point.y+directionY[direction]);
        boolean done = spiralOrderHelper(matrix, set, new_point, ans, direction);
        
        if(!done) {
            new_point = new Point(point.x+directionX[(direction+1)%4],point.y+directionY[(direction+1)%4]);
            return spiralOrderHelper(matrix, set, new_point, ans, (direction+1)%4); 
        }
        return true;
    }
}