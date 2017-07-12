import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {
	private int min = 1;
	private int capacity;
	private HashMap<Integer, Integer> values;
	private HashMap<Integer, Integer> count;
	private HashMap<Integer, LinkedHashSet<Integer>> freqList;
	
    public LFUCache(int capacity) {
        this.capacity = capacity;
        values = new HashMap<Integer, Integer>();
        count = new HashMap<Integer, Integer>();
        freqList = new HashMap<Integer, LinkedHashSet<Integer>>();
        freqList.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
    	if(capacity == 0) {
    		return ;
    	}
    	if(values.containsKey(key)) {
    		values.put(key, value);
    		get(key);
    		return ;
    	}
    	if(capacity == values.size()) {
    		int evict = freqList.get(min).iterator().next();
    		freqList.get(min).remove(evict);
    		values.remove(evict);
    		count.remove(evict);
    	}
        values.put(key, value);
        count.put(key, 1);
        LinkedHashSet<Integer> list = freqList.get(1);
        list.add(key);
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Solution {
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
}