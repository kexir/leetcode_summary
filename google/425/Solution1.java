public class Solution1 {//43 ms
    class TrieNode {
        public String word;
        public TrieNode[] next;
        public TrieNode() {
            word = null;
            next = new TrieNode[26];
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<List<String>>();
        TrieNode root = new TrieNode();
        for(String word : words){
            buildTrieTree(word, root);
        }
        TrieNode[] rows = new TrieNode[words[0].length()];
        for(int i = 0; i < words[0].length(); i++){
            rows[i] = root;
        }
        squareHelper(0, 0, words[0].length(), rows, ans);
        return ans;
    }
    public void buildTrieTree(String word, TrieNode root){
        TrieNode curt = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(curt.next[index] == null) {
                curt.next[index] = new TrieNode();
            }
            curt = curt.next[index];
        }
        curt.word = word;
    }
    public void squareHelper(int row, int col, int n, TrieNode[] rows, List<List<String>> ans){
        if(row == n && col == n){
            List<String> path = new ArrayList<String>();
            for(int i = 0; i < n; i++){
                path.add(rows[i].word);
            }
            ans.add(path);
            return;
        }
        if(col < n){
            TrieNode pre_row = rows[row];
            TrieNode pre_col = rows[col];
            for(int i = 0; i < 26; i++){
                if(rows[row].next[i] != null && rows[col].next[i] != null){
                    rows[row] = rows[row].next[i];
                    if (col != row){
                        rows[col] = rows[col].next[i];
                    } 
                    squareHelper(row, col+1, n, rows, ans);
                    rows[row] = pre_row;
                    if (col != row){
                       rows[col] =  pre_col;
                    }
                }
            }
        }else{
            squareHelper(row+1, row+1, n, rows, ans);
        }
    }
}