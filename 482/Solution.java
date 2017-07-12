public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        
        int count = K;
        for(int i = S.length()-1; i >= 0; i--) {
            if(S.charAt(i) == '-'){
                continue;
            } 
            sb.append(Character.toUpperCase(S.charAt(i)));
            count --;
            if(count == 0) {
                sb.append('-');
                count = K;
            }
        }
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '-'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
    public String licenseKeyFormatting2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    } 
}