import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak2(s, wordDict);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {//18ms
        if(s == null || s.length() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<String>(wordDict);
        boolean[] DP = new boolean[s.length()+1];
        DP[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(DP[i]) {
                    break;
                }
                DP[i] = DP[j] && isWord(s.substring(j,i), dict);
            }
            // System.out.println("DP " + i + " " + DP[i]);
        }
        return DP[s.length()];
    }
    public static boolean isWord(String word, Set<String> dict) {
        return dict.contains(word);
    }
    public static boolean wordBreak2(String s, List<String> wordDict) {//6 ms
        if(s == null || s.length() == 0) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;;
        Set<String> dict = new HashSet<String>();
        for(String word : wordDict) {
            dict.add(word);
            if(word.length() < min) {
                min = word.length();
            }
            if(word.length() > max) {
                max = word.length();
            }
        }
        boolean[] DP = new boolean[s.length()+1];
        DP[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(i-j >= min && i-j <= max) {
                    if(DP[j] && dict.contains(s.substring(j,i))) {
                        DP[i] = true;
                        break;
                    }
                }
            }
        }
        return DP[s.length()];
    }
}