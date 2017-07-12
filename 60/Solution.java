public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n];
        int factor = 1;
        k = k - 1;
        for(int i = 1; i < n; i++) {
            factor *= i;
        }
        for(int i = n-1; i >= 0; i--) {
            int index = k/factor;
            k = k % factor;
            for(int j = 0; j < n; j++) {
                if(visited[j]) {
                    continue;
                }
                if(index == 0 && !visited[j]) {
                    visited[j] = true;
                    sb.append(j+1);
                    break;
                } 
                index--;
            }
            if(i != 0) {
                factor /= i;
            }
        }
        return sb.toString();
    }
}