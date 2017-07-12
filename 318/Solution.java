public class Solution {
    public int maxProduct(String[] words) {//28 ms
        int max = 0;
        int[] bytes = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            char[] char_list = words[i].toCharArray();
            for(char ch : char_list) {
                bytes[i] |= 1 << (ch - 'a');
            }
        }
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if((bytes[i] & bytes[j]) == 0) {
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    public int maxProduct(String[] words) {
        int max = 0;
        int[] bytes = new int[words.length];
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length()-a.length();
            }
        });
        for(int i = 0; i < words.length; i++) {
            char[] char_list = words[i].toCharArray();
            for(char ch : char_list) {
                bytes[i] |= 1 << (ch - 'a');
            }
        }
        for(int i = 0; i < words.length; i++) {//50ms
            if(words[i].length()*words[i].length() < max) {
                break;
            }
            for(int j = i+1; j < words.length; j++) {
                if((bytes[i] & bytes[j]) == 0) {
                    max = Math.max(max, words[i].length()*words[j].length());
                    break;
                }
            }
        }
        return max;
    }
}