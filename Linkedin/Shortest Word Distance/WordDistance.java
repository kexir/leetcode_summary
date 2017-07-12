import java.util.HashMap;
import java.util.ArrayList;

public class WordDistance {
    private HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    public static void main(String[] args) {
        String[] words = {"a","b"};
        WordDistance obj = new WordDistance(words);
        int param_1 = obj.shortest("a","b");
        int param_2 = obj.shortest("b","a");
        System.out.println(param_1);
        System.out.println(param_2);
    }
    public WordDistance(String[] words) {//153 ms
        for(int i = 0; i < words.length; i++) {
            ArrayList<Integer> temp = map.getOrDefault(words[i], new ArrayList<Integer>());
            temp.add(i);
            map.put(words[i], temp);
        }
    }
    
    public int shortest(String word1, String word2) {//153 ms
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        int p1=0, p2=0;
        while(p1 < list1.size() && p2 < list2.size()) {
            ans = Math.min(ans, Math.abs(list1.get(p1)-list2.get(p2)));
            if(list1.get(p1) < list2.get(p2)) {
                p1 ++;
            } else {
                p2 ++;
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */