public class Solution3 {
  public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        int param_1 = shortestWordDistance(words,"makes","makes");
        System.out.println(param_1);
        int param_2 = shortestWordDistance(words,"makes","coding");
        System.out.println(param_2);
    }
    public static int shortestWordDistance(String[] words, String word1, String word2) {//4 ms
        int ans = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                if(word1.equals(word2)) {
                    p2 = p1;
                    p1 = i;
                } else {
                    p1 = i;
                }
            } else if(words[i].equals(word2)) {
                p2 = i;
            }
            if(p1 != -1 && p2 != -1) {
               ans = Math.min(ans,Math.abs(p1-p2));
            }
        }
        return ans;
    }
}