import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String[][] tickets = {{"JFK","SFO"}, {"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(findItinerary(tickets));
    }
    public static List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return ans;
        }
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            if(!map.containsKey(from)) {
                map.put(from, new PriorityQueue<String>());
            }
            map.get(from).add(tickets[i][1]);
        }
        findItineraryHelper("JFK", map, ans);
        Collections.reverse(ans);
        return ans;
    }
    public static void findItineraryHelper(String current, HashMap<String, PriorityQueue<String>> map, List<String> ans) {
        while(map.containsKey(current) && !map.get(current).isEmpty()) {  
           findItineraryHelper(map.get(current).poll(), map, ans);
        }
        ans.add(current);
        // System.out.println(ans);
    }
}