import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Solution {
    public static void main(String[] args) {
        String path = "/home/../../..";
        System.out.println(simplifyPath(path)); 
        path = "///eHx/..";
        System.out.println(simplifyPath(path)); 
    }
    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<String>();
        path += "/";
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == '/'){
                if(sb.length() == 0 || sb.toString().equals(".")) {
                    sb.delete(0,sb.length());
                    continue;
                } else if(sb.toString().equals("..")){
                    if(stack.size() != 0) {
                        stack.removeLast();
                    }
                } else {
                    stack.addLast(sb.toString());
                }
                sb.delete(0,sb.length());
            } else {
                sb.append(path.charAt(i));
            }
        }
        if(stack.size() == 0){
            return "/";
        }
        ListIterator<String> iter = stack.listIterator();
        sb = new StringBuilder();
        while(iter.hasNext()) {
            sb.append("/"+iter.next());
        }
        return sb.toString();
    } 
}