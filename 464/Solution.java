public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal || desiredTotal <= 0) {
            return true;
        }
        if(maxChoosableInteger*(1+maxChoosableInteger)/2 < desiredTotal){
            return false;
        }
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        boolean[] state = new boolean[maxChoosableInteger+1];
        return canIWinHelper(desiredTotal, map, state);
    }
    public boolean canIWinHelper(int desiredTotal, HashMap<Integer, Boolean> map, boolean[] state) {
        if(desiredTotal <= 0) {
            return false;
        }
        int key = formatState(state);
        if(!map.containsKey(key)) {
            for(int i = 1; i < state.length; i++){
                if(!state[i]) {
                    state[i] = true;
                    if(!canIWinHelper(desiredTotal-i, map, state)){
                        map.put(key, true);
                        state[i] = false;
                        return true;
                    }
                    state[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
    public int formatState(boolean[] state) {
        int num = 0;
        for(int i = 0; i < state.length; i++) {
            num <<= 1;
            if(state[i]) {
                num |= 1;
            }
        }
        return num;
    }
}