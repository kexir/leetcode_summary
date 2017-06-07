import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class Word_LadderII_2End {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot");
        System.out.println(findLadders(beginWord, endWord, wordList)); 
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<List<String>>();
        HashSet<String> wordDict = new HashSet<String>(wordList);
        if(!wordDict.contains(endWord)) {
            return ans;
        }
        HashSet<String> begin = new HashSet<String>();
        HashSet<String> end = new HashSet<String>();
        begin.add(beginWord);
        end.add(endWord);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        bfs(begin, end, wordDict, map, false);

        dfs(ans, new ArrayList<String>(), beginWord, endWord, map);
        return ans;
    }
    public static void dfs(List<List<String>> ans, ArrayList<String> path, String beginWord, String endWord, HashMap<String, ArrayList<String>> map){
    	path.add(beginWord);
    	if(beginWord.equals(endWord)) {
            ans.add(new ArrayList<String>(path));
            return;
        }
        if(!map.containsKey(beginWord)) {
            return;
        }
        // System.out.println(map.get(beginWord));
        for(String word : map.get(beginWord)) {
            dfs(ans, path, word, endWord, map);
            path.remove(path.size()-1);
        }
    	
    }
    public static void bfs(HashSet<String> begin, HashSet<String> end, HashSet<String> wordDict, HashMap<String, ArrayList<String>> map, boolean flip) {
    	System.out.println(begin);
        System.out.println(end);
        if(begin.size() == 0) {
            return;
        }
        if(begin.size() > end.size()) {
            bfs(end, begin, wordDict, map, !flip);
            return;
        }
        wordDict.removeAll(begin);
    	boolean flag = false;
        HashSet<String> temp = new HashSet<String>();
        for(String word : begin) {
            for (String newWord : neighborList(word, wordDict)) {
                if(end.contains(newWord)) {
                    flag = true;
                } else {
                    temp.add(newWord);
                }
                if(!flip) {
                    ArrayList<String> list = map.containsKey(word)? map.get(word): new ArrayList<String>();
                    list.add(newWord);
                    map.put(word, list);
                } else {
                    ArrayList<String> list = map.containsKey(newWord)? map.get(newWord): new ArrayList<String>();
                    list.add(word);
                    map.put(newWord, list);
                }
            }
        }
        if(!flag) {
            // System.out.println(temp);
            // System.out.println(end);
            bfs(temp, end, wordDict, map, flip);	
        }
    }
    public static ArrayList<String> neighborList(String target, HashSet<String> dict)  {
        ArrayList<String> ans = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int j = 0; j < target.length(); j++) {
                String newWord = target.substring(0,j) + c + target.substring(j+1,target.length());
                if(dict.contains(newWord)) {
                    ans.add(newWord);
                }
            }
        }
        return ans;
    }
}