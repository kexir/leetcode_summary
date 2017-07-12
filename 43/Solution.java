public class Solution {
    // there is no a == 0 | b == 0 continue, because pos[i+j] may larger than 10 need to be deal with cannot skip 
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        int[] pos = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i >= 0; i--) {
            int a = num1.charAt(i)-'0';
            for(int j = num2.length()-1; j >= 0; j--) {
                int b = num2.charAt(j)-'0';
                int sum = a*b + pos[i+j+1];
                pos[i+j+1] = sum%10;
                pos[i+j] += sum/10;
                
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num1.length()+num2.length(); i++) {
            if(pos[i] == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(pos[i]);
        }
        return sb.length() == 0? "0":sb.toString();
    }
}