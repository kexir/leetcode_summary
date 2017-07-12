//Shortest Word Distance
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {//17 ms
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> temp;
        for(int i = 0; i < words.length; i++) {
            temp =  map.getOrDefault(words[i], new ArrayList<Integer>());
            temp.add(i);
            map.put(words[i], temp);
            if(words[i].equals(word1)) {
                temp = map.get(word2);
                if(temp != null && temp.size() != 0) {
                    ans = Math.min(ans, Math.abs(i-temp.get(temp.size()-1)));
                }
            }
            if(words[i].equals(word2)) {
                temp = map.get(word1);
                if(temp != null && temp.size() != 0) {
                    ans = Math.min(ans, Math.abs(i-temp.get(temp.size()-1)));
                }
            }
        }
        return ans;
    }
    public int shortestDistance2(String[] words, String word1, String word2) {//5ms
        int p1 = -1;
        int p2 = -1;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                p1 = i;
            }
            if(words[i].equals(word2)) {
                p2 = i;
            }
            // System.out.println(words[i] + " " + p1 + " " + p2);
            if(p1 != -1 && p2 != -1) {
                ans = Math.min(ans, Math.abs(p1-p2));
            }
            
        }
        return ans;
    }
}