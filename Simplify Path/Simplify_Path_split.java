import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
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
        LinkedList<String> stack = new LinkedList<String>();
        Set<String> skip = new HashSet<String>(Arrays.asList("..",".",""));
        for(String dir : path.split("/")) {
            if(dir.equals("..") && stack.size() != 0) {
                stack.removeLast();
            } else if (!skip.contains(dir)) {
                stack.addLast(dir);
            }
        }
        if(stack.size() == 0) {
            return "/";
        }
        ListIterator<String> iter = stack.listIterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()) {
            sb.append("/"+iter.next());
        }
        return sb.toString();
    } 
}