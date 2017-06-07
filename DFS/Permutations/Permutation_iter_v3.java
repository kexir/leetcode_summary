import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        for(List<Integer> l : result){
            System.out.println(l);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        ArrayList<Integer> stack = new ArrayList<Integer>();
        stack.add(-1);
        while(stack.size() != 0){
            Integer last = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            int next = -1;
            for(int i = last+1; i < nums.length; i++){
                if(!stack.contains(i)){
                    next = i;
                    break;
                }
            } 
            if(next == -1){
                continue;
            }
            stack.add(next);
            for(int i = 0; i < nums.length; i++){
                if(!stack.contains(i)){
                    stack.add(i);
                }
            }
            ArrayList<Integer> permute = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++){
                permute.add(nums[stack.get(i)]);
            }
            result.add(permute);
        }
        return result;
    }
}