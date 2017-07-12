public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0) {
            return null;
        }
        if(a.length() == 0 || b.length() == 0) {
            return a.length() == 0? b:a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i)-'0';
                i--;
            }
            if(j >= 0) {
                sum += b.charAt(j)-'0';
                j--;
            }
            carry = sum/2;
            sb.append(sum%2);
        }
        return sb.reverse().toString();
    }
    public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0) {
            return null;
        }
        if(a.length() == 0 || b.length() == 0) {
            return a.length() == 0? b:a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int flag = 0;
        while(i >= 0 && j >= 0) {
            int c = (a.charAt(i)-'0')+(b.charAt(j)-'0')+flag;
            flag = c/2;
            sb.insert(0,c%2);
            i--;
            j--;
        }
        while(i >= 0) {
            int c = (a.charAt(i)-'0')+flag;
            flag = c/2;
            sb.insert(0,c%2);
            i--;
        }
        while(j >= 0) {
            int c = (b.charAt(j)-'0')+flag;
            flag = c/2;
            sb.insert(0,c%2);
            j--;
        }
        if(flag == 1) {
            sb.insert(0,flag);
        }
        return sb.toString();
    }
}