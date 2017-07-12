public class Solution {
    public List<List<String>> wordSquares(String[] words) {// 146 ms
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                HashSet<String> set = map.getOrDefault(word.substring(0,i), new HashSet<String>());
                set.add(word);
                map.put(word.substring(0,i), set);
            }
        }
        wordSquaresHelper(0, words[0].length(), map, path, ans);
        return ans;
    }
    public void wordSquaresHelper(int i, int n, HashMap<String, HashSet<String>> map, List<String> path, List<List<String>> ans){
        if(i == n){
            ans.add(new ArrayList<String>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < i; j++) {
            sb.append(path.get(j).charAt(i));
        }
        HashSet<String> set = map.get(sb.toString());
        if(set == null) {
            return;
        }
        for(String candidate : set) {
            path.add(candidate);
            wordSquaresHelper(i+1, n, map, path, ans);
            path.remove(path.size()-1);
        }
    }
}