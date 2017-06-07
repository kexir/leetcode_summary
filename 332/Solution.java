import java.util.List;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String[][] tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]];
        System.out.println(findItinerary(tickets));
    }
    public List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return ans;
        }
        HashMap<String, TreeSet<String>> map = new HashMap<String, TreeSet<String>>();
        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            if(!map.containsKey(from)) {
                map.put(from, new TreeSet<String>());
            }
            map.get(from).add(tickets[i][1]);
        }
        String begin = "JFK";
        ans.add(begin);
        while(begin != null) {
            String next = map.get(begin).pollFirst();
            if(next != null) {
                ans.add(next);
            }
            begin = next;
        }
        return ans;
    }
}