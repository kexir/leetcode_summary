import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

public class Word_Ladder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList)); 
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>();
        for(String word : wordList) {
            dict.add(word);
        }
        
        HashSet<String> visited = new HashSet<String>();

        HashSet<String> begin = new HashSet<String>();
        HashSet<String> end = new HashSet<String>(); 
        begin.add(beginWord);
        end.add(endWord);
        visited.add(endWord);
        int count = 1;
        while(!begin.isEmpty() && !end.isEmpty()) {
            count ++;
            if(begin.size() > end.size()) {
                HashSet<String> t = new HashSet<String>(begin);
                begin = end;
                end = t;  
            }
            HashSet<String> temp = new HashSet<String>(); 
            for(String word : begin) {
                for(char c = 'a'; c <= 'z'; c++) {
                    for(int i = 0; i < word.length(); i++) {
                        if(word.charAt(i) == c) {
                            continue;
                        }
                        String nextWord = replace(word,i,c);
                        if(dict.contains(nextWord)) {
                            if(end.contains(nextWord)) {
                                
                                return count;
                            }
                            if(visited.contains(nextWord)){
                                continue;
                            }
                            temp.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            begin = temp;
            System.out.println(count);
            System.out.println(begin);
            System.out.println(end);
        }

        return 0;
    }

    public static String replace(String word, int i, char c) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}