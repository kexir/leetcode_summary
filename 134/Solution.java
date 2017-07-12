public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {//O(n^2) Time Limit Exceed
        int start = 0;
        int end = start+1;
        int sum = gas[0] - cost[0];
        while(start < gas.length && end < gas.length) {
            if(sum < 0) {
                start++;
                if(start >= gas.length) {
                    break;
                } 
                end = (start +1)%gas.length;
                sum = gas[start] - cost[start];
                continue;
            }
            sum += gas[end] - cost[end]; 
            end = (end+1)%gas.length;
            if(start == end && sum >= 0) {
                return start;
            }
        }
        return sum >= 0? start:-1;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {//O(n) 1ms
        /*If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
          If the total number of gas is bigger than the total number of cost. There must be a solution.*/   
        int tank = 0;
        int total = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i]-cost[i];
            if(tank < 0) {
                total += tank;
                start = i+1;
                tank = 0;
            }
        }
        return total+tank<0? -1: start;
    }
}