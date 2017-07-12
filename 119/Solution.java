public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        for(int i =0; i<=rowIndex; i++){
            pre.add(0,1);
            for(int j=1; j <i; j++){
                pre.set(j, pre.get(j)+pre.get(j+1));
            }
        }
        return pre;
    }
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> prev = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        if(rowIndex == 0) {
            return ans;
        }
        for(int i = 1; i <= rowIndex; i++) {
            ans = new ArrayList<Integer>();
            ans.add(1);
            for(int j = 0; j < prev.size()-1; j++) {
                ans.add(prev.get(j)+prev.get(j+1));
            }
            ans.add(1);
            prev = ans;
        }
        return ans;
    }
}