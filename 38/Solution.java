public class Solution {
    public String countAndSay(int n) {//7 ms
        StringBuilder prev = new StringBuilder();
        prev.append("1");
        StringBuilder curt = new StringBuilder();
        
        for(int i = 1; i < n; i++) {
            int count = 1;
            char last = prev.charAt(prev.length()-1);
            for(int j = 1; j < prev.length(); j++) {
                if(prev.charAt(j) == prev.charAt(j-1)) {
                    count ++;
                } else {
                    curt.append(count).append(prev.charAt(j-1));
                    count = 1;
                }
            }
            curt.append(count).append(last);
            prev = curt;
            curt = new StringBuilder();
        }
        
        return prev.toString();
    }
    
}