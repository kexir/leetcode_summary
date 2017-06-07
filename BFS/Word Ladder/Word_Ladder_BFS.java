public class Solution {
    public static void main(String[] args) {
        String beginWord = "nanny";
        String endWord = "aloud";
        List<String> wordList = new List<String>();
        System.out.println(ladderLength()); 
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>();
        for(String word : wordList) {
            dict.add(word);
        }
        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>(); 
        queue.offer(beginWord);
        set.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            count ++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String temp = queue.poll();
                for(String word : neighborList(temp, dict)) {
                    if (set.contains(word)) {
                        continue;
                    }
                    if(word.equals(endWord)) {
                        return count;
                    }
                    queue.offer(word);
                    set.add(word);
                }
            }
        }
        return 0;
    }
    public ArrayList<String> neighborList(String target, HashSet<String> dict) {
        ArrayList<String> ans = new ArrayList<String>();
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < target.length(); i++) {
                if(target.charAt(i) == c) {
                    continue;
                }
                String temp = replace(target,i,c);
                if(dict.contains(temp)){
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    public String replace(String word, int i, char c) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}