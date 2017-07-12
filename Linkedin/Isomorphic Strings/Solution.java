public class Solution {
    public boolean isIsomorphic(String s, String t) {//64 ms slow
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Character> map1 = new HashMap<Character,Character>();
        HashMap<Character,Character> map2 = new HashMap<Character,Character>();
        for(int i = 0; i < s.length(); i++) {
            if(map1.containsKey(s.charAt(i))) {
                if(map1.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            if(map2.containsKey(t.charAt(i))) {
                if(map2.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }
            map1.put(s.charAt(i), t.charAt(i));
            map2.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {//21 ms
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            } else {
                if(map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
    public boolean isIsomorphic3(String s, String t) {//8 ms
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map1 = new int [256];
        int[] map2 = new int [256];
        for(int i = 0; i < s.length(); i++) {
            if(map1[s.charAt(i)] != 0) {
                if(map1[s.charAt(i)] != map2[t.charAt(i)]) {
                    return false;
                }
            }else{
                if(map2[t.charAt(i)] != 0) {
                    return false;
                }
                map1[s.charAt(i)] = i+1;
                map2[t.charAt(i)] = i+1;
            }
        }
        return true;
    }
    public boolean isIsomorphic4(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map1 = new int [256];
        int[] map2 = new int [256];
        for(int i = 0; i < s.length(); i++) {
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }
            map1[s.charAt(i)] = i+1;
            map2[t.charAt(i)] = i+1;
        }
        return true;
    }
}