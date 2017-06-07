import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class Word_LadderII_BFS_DFS {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(findLadders(beginWord, endWord, wordList)); 
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordDict = new HashSet<String>(wordList);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        map.put(beginWord, new ArrayList<String>());
        map.put(endWord, new ArrayList<String>());
        bfs(beginWord, endWord, wordDict, map, distance);

        List<List<String>> ans = new ArrayList<List<String>>();
        ArrayList<String> path = new ArrayList<String>();
        dfs(ans, path, endWord, beginWord, map, distance);

        return ans;
    }
    public static void dfs(List<List<String>> ans, ArrayList<String> path, String endWord, String beginWord, HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance){
    	path.add(endWord);
    	if (endWord.equals(beginWord)) {
    		Collections.reverse(path);
    		ans.add(new ArrayList<String>(path));
    		Collections.reverse(path);
    	} else {
    		for(String word : map.get(endWord)) {
    			if(distance.containsKey(word) && distance.get(word) == distance.get(endWord) -1) {
    				dfs(ans, path, word, beginWord, map, distance);
    			}
    		}
    	}
    	path.remove(path.size()-1);
    }
    public static void bfs(String beginWord, String endWord, HashSet<String> wordDict, HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance) {
    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(beginWord);
    	distance.put(beginWord, 0);
    	Boolean flag = true;
    	while(!queue.isEmpty() && flag) {
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			String word = queue.poll();
    			for (String newWord : neighborList(word, wordDict)) {
    				if(newWord.equals(endWord)) {
                        flag = false;
                    }
                    if(!map.containsKey(newWord)) {
                    	map.put(newWord, new ArrayList<String>());
                    }
                    map.get(newWord).add(word);
                    if(!distance.containsKey(newWord)) {
                    	distance.put(newWord, distance.get(word)+1);
                    	// System.out.println(newWord + " " + (distance.get(word)+1));
                    	queue.offer(newWord);
                    }
                }
    		}
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