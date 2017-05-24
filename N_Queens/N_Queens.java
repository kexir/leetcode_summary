import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args){
        List<List<String>> graph = solveNQueens(9);
        for(List<String> list : graph){
            System.out.println(list);
        } 
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n <= 0){
            return result;
        }
        search(result, new ArrayList<Integer>(), n);
        return result;
    }
    public static void search(List<List<String>> result, ArrayList<Integer> temp, int n){
        if(temp.size() == n){
            ArrayList<String> graph = drawChessboard(temp);
            result.add(graph);
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(temp, i)){
                temp.add(i);
                search(result, temp, n);
                temp.remove(temp.size()-1);
            }
        }

    }
    public static ArrayList<String> drawChessboard(ArrayList<Integer> col){
        ArrayList<String> chessboard = new ArrayList<>();
        for(int i = 0; i < col.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col.size(); j++){
                sb.append(col.get(i) == j? 'Q':'.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
    public static boolean isValid(ArrayList<Integer> cols, int column){
        int row = cols.size();
        for(int i = 0; i < cols.size(); i++){
            if(cols.get(i) == column){
                return false;
            }
            if(row + cols.get(i) == i + column){
                return false;
            }
            if(row - cols.get(i) == i - column){
                return false;
            }
        }
        return true;
    }
}