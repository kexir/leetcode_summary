import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> ans = findRepeatedDnaSequences(s);
        System.out.println(ans);
    }
    public static List<String> findRepeatedDnaSequences(String s) {// 58 ms
        if(s == null || s.length() < 10) {
            return new ArrayList<String>();
        }
        HashSet<String> ans = new HashSet<String>();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i <= s.length()-10; i++) {
            if(set.contains(s.substring(i,i+10))) {
                ans.add(s.substring(i,i+10));
            } else {
                set.add(s.substring(i,i+10));
            }
        }
        return new ArrayList<String>(ans);
    }
    public List<String> findRepeatedDnaSequences(String s) {// 31 ms
        if(s == null || s.length() < 10) {
            return new ArrayList<String>();
        }
        int[] mapping = new int[26];
        mapping['A'-'A'] = 0;
        mapping['C'-'A'] = 1;
        mapping['G'-'A'] = 2;
        mapping['T'-'A'] = 3;
        int hashKey = 0;
        char[] count = new char[1 << 21];
        List<String> ans = new ArrayList<String>();
        for(int i = 0; i < 9; i++) {
           hashKey = (hashKey << 2) | mapping[s.charAt(i)-'A'];
        }
        for(int i = 9; i < s.length(); i++) {
            hashKey = ((hashKey << 2) | mapping[s.charAt(i)-'A']) & 0xfffff;
            if(count[hashKey]++ == 1) {
                ans.add(s.substring(i-9,i+1));
            }
        }
        return ans;
    }
}
