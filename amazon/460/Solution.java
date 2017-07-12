import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;

class Records {
	public int key;
	public int freq;
	public Records(int key, int freq) {
		this.key = key;
		this.freq = freq;
	}
}
class LFUCache {
	private int capacity;
	private PriorityQueue<Records> queue;
	private HashMap<Integer, Integer> object;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        queue = new PriorityQueue<>(capacity, new Comparator<>() {
        	public int compare( a,  b) {
        		return 
        	}
        });
        object = new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
    	if(!object.containsKey(key)) {
    		return -1;
    	}
        return object.get(key);
    }
    
    public void put(int key, int value) {
        if(object.size() == capacity) {
        	Records temp = queue.poll();
        	object.remove(temp.key);
        	System.out.println("reomove key "+temp.key);
        }
        object.put(key, value);
        
        System.out.println("map push key "+key+" value "+value);
        System.out.println("queue push records key "+key);
    }
}

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

