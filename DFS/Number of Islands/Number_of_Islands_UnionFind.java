class UnionFind {
    private int[] father;
    private int count;
    public UnionFind(int n) {
        father = new int[n];
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    private int find(int x) {
        if(father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void connect(int a, int b) {        
        int root_a = find(a);        
        int root_b = find(b);
        if(root_a != root_b) {
            father[root_a] = root_b;
            count -- ;
        }
    }
    public void set_count(int n) {
        count = n;
    }
    public int query() {
        return count;
    }
}
public class Solution {
    public static void main(String[] args) {
        char[][] grid ={{'1'},{'1'}};
        System.out.println(numIslands(grid)); 
    }
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind union_find = new UnionFind(m*n);
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                }
            }
        }
        union_find.set_count(count);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    if(i > 0 && grid[i-1][j] == '1') {
                        union_find.connect(i*n+j, (i-1)*n+j);
                    }
                    if(i < m-1 && grid[i+1][j] == '1') {
                        union_find.connect(i*n+j, (i+1)*n+j);
                    }
                    if(j > 0 && grid[i][j-1] == '1') {
                        union_find.connect(i*n+j, i*n+j-1);
                    }
                    if(j < n-1 && grid[i][j+1] == '1') {
                        union_find.connect(i*n+j, i*n+j+1);
                    }
                }
            }
        }
        return union_find.query();
    }
}