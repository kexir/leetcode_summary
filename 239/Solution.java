import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
	public static void main(String[] args) {
        int[] nums = {2,1,3,4,6,3,8,9,10,12,56};
        int[] ans = maxSlidingWindow2(nums, 4);
        for(int i = 0; i < ans.length; i++) {
        	System.out.print(ans[i]+",");
        }
        System.out.println();
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {//O(nlogk)
    	if(nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		return b.compareTo(a);
        	}
        });
        int[] ans = new int[nums.length-k+1];
        for(int i = 0; i < k; i++) {
        	queue.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++) {
        	ans[i-k] = queue.peek();
        	queue.remove(nums[i-k]);
        	queue.add(nums[i]);
        }
        ans[nums.length-k] = queue.peek();
        return ans;
    }
     public static int[] maxSlidingWindow2(int[] nums, int k) {//O(2n) 8 ms
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++) {
            left[i] = i%k == 0? nums[i]: Math.max(left[i-1], nums[i]);
            int j = nums.length-1-i;
        	right[j] = (j+1)%k == 0? nums[j]: Math.max(right[j+1], nums[j]);
        }
        // left = 2,3,4,6,6,8,9,10,12,56,
        // right = 4,4,4,9,9,9,9,56,56,56
       
        int[] ans = new int[nums.length-k+1];
        for(int i = 0; i < nums.length-k+1; i++) {
            ans[i] = Math.max(left[i+k-1], right[i]);	
        }
        return ans;
    }
    public static int[] maxSlidingWindow3(int[] nums, int k) {//O(3n)24 ms
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int index = 0;
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k-1) {
                ans[index++] = nums[deque.peek()];
            }
        }
        return ans;
    }
}